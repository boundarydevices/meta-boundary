inherit image_types

BOOT_START = "4"
BOOT_SIZE = "32"
BOOT_END = "36"
ROOTFS_START = "36"
ROOTFS_SIZE = "700"
ROOTFS_END = "736"
APPFS_START = "740"
APPFS_SIZE = "2856"
APPFS_END = "3596"
SDCARD_SIZE = "3600"
SDCARD = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.sdcard"
IMAGE_BOOTLOADER = "u-boot"

IMAGE_DEPENDS_boundary = "parted-native:do_populate_sysroot \
                        dosfstools-native:do_populate_sysroot \
                        mtools-native:do_populate_sysroot \
                        virtual/kernel:do_deploy \
                        ${@d.getVar('IMAGE_BOOTLOADER', True) and d.getVar('IMAGE_BOOTLOADER', True) + ':do_deploy' or ''}"
                        
create_blank_sdcard_file () {
	# Initialize a sparse file
	dd if=/dev/zero of=${SDCARD} bs=1M count=0 seek=${SDCARD_SIZE}
	# Create partition table
	parted -s ${SDCARD} mklabel msdos
}

create_and_burn_boot () {
	# create boot partition
	parted -s ${SDCARD} unit MiB mkpart primary fat32 ${BOOT_START} ${BOOT_END}

	# Create boot partition image
  [ -e ${WORKDIR}/boot.img ] && rm ${WORKDIR}/boot.img
  dd if=/dev/zero of=${WORKDIR}/boot.img bs=1M count=0 seek=${BOOT_SIZE}
	mkfs.vfat -n "BOOT" -S 512 ${WORKDIR}/boot.img
	mcopy -i ${WORKDIR}/boot.img -s ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin ::/${KERNEL_IMAGETYPE}

	# Copy boot scripts
	for item in ${BOOT_SCRIPTS}; do
		src=`echo $item | awk -F':' '{ print $1 }'`
		dst=`echo $item | awk -F':' '{ print $2 }'`

		mcopy -i ${WORKDIR}/boot.img -s ${DEPLOY_DIR_IMAGE}/$src ::/$dst 
                ## FIXME in the class code ---------^
	done

	# Copy device tree file
	for DTS_FILE in ${KERNEL_DEVICETREE}; do
		DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`
		if [ -e "${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${DTS_BASE_NAME}.dtb" ]; then
			kernel_bin="`readlink ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin`"
			kernel_bin_for_dtb="`readlink ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${DTS_BASE_NAME}.dtb | sed "s,$DTS_BASE_NAME,${MACHINE},g;s,\.dtb$,.bin,g"`"
			if [ $kernel_bin = $kernel_bin_for_dtb ]; then
				mcopy -i ${WORKDIR}/boot.img -s ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${DTS_BASE_NAME}.dtb ::/${DTS_BASE_NAME}.dtb
			fi
		fi
	done

	# Burn Partition
	dd if=${WORKDIR}/boot.img of=${SDCARD} conv=notrunc seek=${BOOT_START} bs=1M
}

create_and_burn_rootfs () {
	# Create Partition
	parted -s ${SDCARD} unit MiB mkpart primary ${ROOTFS_START} ${ROOTFS_END}
	
	# Temporarily move the app&boot folders away and leave empty mount point for partition creation
	
	[ -d ${IMAGE_ROOTFS}/../app ] && rm -rf ${IMAGE_ROOTFS}/../app
	mv ${IMAGE_ROOTFS}/app ${IMAGE_ROOTFS}/../
	mkdir ${IMAGE_ROOTFS}/app
	[ -d ${IMAGE_ROOTFS}/../boot ] && rm -rf ${IMAGE_ROOTFS}/../boot
	mv ${IMAGE_ROOTFS}/boot ${IMAGE_ROOTFS}/../
	mkdir ${IMAGE_ROOTFS}/boot
	# Create rootfs image
	rootfs=`mktemp`
	dd if=/dev/zero of=$rootfs seek=${ROOTFS_SIZE} count=0 bs=1M
	mkfs.ext4 -F -i 4096 -L "rootfs" ${rootfs} -d ${IMAGE_ROOTFS}
	dd if=${rootfs} of=${SDCARD} conv=notrunc seek=${ROOTFS_START} bs=1M
	rm $rootfs
	rm -rf ${IMAGE_ROOTFS}/app
	mv ${IMAGE_ROOTFS}/../app ${IMAGE_ROOTFS}/app
	rm -rf ${IMAGE_ROOTFS}/boot
	mv ${IMAGE_ROOTFS}/../boot ${IMAGE_ROOTFS}/boot
}

create_and_burn_appfs () {
	# Create Partition
	parted -s ${SDCARD} unit MiB mkpart primary ${APPFS_START} ${APPFS_END}
							
	# write the application partition
	appfs=`mktemp`
	dd if=/dev/zero of=$appfs bs=1M count=0 seek=${APPFS_SIZE}
	mkfs.ext4 -L "app" -F -i 4096 ${appfs} -d ${IMAGE_ROOTFS}/app
	dd if=${appfs} of=${SDCARD} conv=notrunc seek=${APPFS_START} bs=1M
	rm $appfs
}

create_sdcard_symlink() {
	SDCARD_LINK=`echo ${IMAGE_NAME} | awk -F "-${MACHINE}" '{ print $1 }'`
	[ -e ${DEPLOY_DIR_IMAGE}/${SDCARD_LINK}.sdcard ] && rm ${DEPLOY_DIR_IMAGE}/${SDCARD_LINK}.sdcard
	ln -s ${SDCARD} ${DEPLOY_DIR_IMAGE}/${SDCARD_LINK}.sdcard
}

IMAGE_CMD_boundary () {
	if [ -z "${SDCARD_ROOTFS}" ]; then
		bberror "SDCARD_ROOTFS is undefined. To use sdcard image from Freescale's BSP it needs to be defined."
		exit 1
	fi

	create_blank_sdcard_file
	create_and_burn_boot
	create_and_burn_rootfs
	create_and_burn_appfs
	create_sdcard_symlink
}
