require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-boundary-common_${PV}.inc

DEPENDS += "bison-native dtc-native python3-setuptools-native"

PROVIDES += "u-boot"

COMPATIBLE_MACHINE = "(nitrogen6x-lite|nitrogen6x|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm|nitrogen8mn|nitrogen8mp|tungsten-510-smarc|tungsten-700-smarc)"

# Below copied from meta-rity/meta/recipes-bsp/u-boot

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS += "bc-native dtc-native u-boot-tools-native"

SRC_URI += " \
	file://boot.script \
	${@bb.utils.contains("DISTRO_FEATURES", "secure-boot", "file://secure-boot.cfg", "", d)} \
	file://fdt-env.cfg \
	file://0001-cmd-Add-new-command-to-source-embedded-script.patch \
	file://0001-cmd-Add-new-command-dtbprobe.patch \
	file://boot.script.its \
	${@bb.utils.contains("DISTRO_FEATURES", "fwupdate", "file://secure-cap.dts", "", d)} \
	${@bb.utils.contains("DISTRO_FEATURES", "fwupdate", "file://u-boot-cap.key", "", d)} \
	${@bb.utils.contains("DISTRO_FEATURES", "fwupdate", "file://u-boot-cap.crt", "", d)} \
	${@bb.utils.contains("DISTRO_FEATURES", "fwupdate", "file://u-boot-cap", "", d)} \
	file://fw_env.config \
"

UBOOT_MKIMAGE_CMD = "${@bb.utils.contains("DISTRO_FEATURES", "secure-boot", "${UBOOT_MKIMAGE_SIGN} -F -k ${UBOOT_SIGN_KEYDIR}", "${UBOOT_MKIMAGE}", d)}"

do_uboot_env() {
        boot_conf=`echo "#conf-${KERNEL_DEVICETREE}" | tr '/' '_'`
        fastboot_entry="setenv fastboot_entry 0"
        storage="mmc"
        storage_dev="0"

        if [ "${@bb.utils.contains('MACHINE_FEATURES', 'ufs-boot', 'ufs-boot', '', d)}" = "ufs-boot" ]; then
                storage="scsi"
                storage_dev="2"
        fi

        for dtbo in ${KERNEL_DEVICETREE_OVERLAYS_AUTOLOAD};
        do
                boot_conf="$boot_conf#conf-$dtbo"
        done

        if [ "${1}" = "u-boot.dtb" ]; then
                dtc -I dtb -O dts -o ${B}/u-boot-mtk-config.dts ${B}/${UBOOT_DTB_BINARY}
cat >> ${B}/u-boot-mtk-config.dts <<- EOC
/ {
        config {
                environment {
                        check_fastboot_entry = "$fastboot_entry";
                        fdt_boot_conf = "$boot_conf";
                        storage = "$storage";
                        storage_dev = "$storage_dev";
                        boot_scripts = "fitImage";
                };
        };
};
EOC
                dtc -I dts -O dtb -o ${B}/${UBOOT_DTB_BINARY} ${B}/u-boot-mtk-config.dts

        if [ "${@bb.utils.contains("DISTRO_FEATURES", "fwupdate", "1", "0", d)}" = "1" ]; then
                dtc -I dts -O dtb -o ${B}/secure-cap.dtbo ${WORKDIR}/secure-cap.dts
                fdtoverlay -i ${B}/${UBOOT_DTB_BINARY} -o ${B}/${UBOOT_DTB_BINARY} -v ${B}/secure-cap.dtbo
        fi

        fi

	if [ "${1}" = "u-boot-initial-env" ]; then
		echo dtb_path="/FIRMWARE/mediatek/${MACHINE}/" >> ${DEPLOYDIR}/u-boot-initial-env
		echo efi_dtb_prefixes="\${dtb_path} / /dtb/ /dtb/current/" >> ${DEPLOYDIR}/u-boot-initial-env
		echo check_fastboot_entry=$fastboot_entry >> ${DEPLOYDIR}/u-boot-initial-env
		echo boot_conf=$boot_conf >> ${DEPLOYDIR}/u-boot-initial-env
		echo "list_dtbo=${KERNEL_DEVICETREE_OVERLAYS_AUTOLOAD}" >> ${DEPLOYDIR}/u-boot-initial-env
		echo storage=$storage >> ${DEPLOYDIR}/u-boot-initial-env
		echo storage_dev=$storage_dev >> ${DEPLOYDIR}/u-boot-initial-env
		echo "boot_scripts=fitImage" >> ${DEPLOYDIR}/u-boot-initial-env
		echo boot_targets=embedded >> ${DEPLOYDIR}/u-boot-initial-env
		/bin/echo -e "distro_bootcmd=for target in \x24{boot_targets}; do if test \"\x24{target}\" != \"embedded\"; then dtbprobe \x24{storage} \x24{storage_dev} \x24{dtb_path}; fi; run bootcmd_\x24{target}; done" >> ${DEPLOYDIR}/u-boot-initial-env
		/bin/echo -e "scan_dev_for_efi=run boot_efi_bootmgr;if test -e \x24{devtype} \x24{devnum}:\x24{distro_bootpart} efi/boot/bootaa64.efi; then echo Found EFI removable media binary efi/boot/bootaa64.efi; run boot_efi_binary; echo EFI LOAD FAILED: continuing...; fi" >> ${DEPLOYDIR}/u-boot-initial-env
	fi
}

do_install:append() {
	# Append boot script binary to the end of u-boot binary
	cd ${WORKDIR}
	${UBOOT_MKIMAGE_CMD} -f ${WORKDIR}/boot.script.its ${WORKDIR}/boot.script.bin
	cat ${B}/${UBOOT_BINARY} ${WORKDIR}/boot.script.bin > ${D}/boot/${UBOOT_IMAGE}
}

do_deploy:append() {
	if [ ${@bb.utils.contains("DISTRO_FEATURES", "secure-boot", "1", "0", d)} = "0" ]; then
		do_uboot_env "u-boot-initial-env"
	fi

	if [ ${@bb.utils.contains("DISTRO_FEATURES", "fwupdate", "1", "0", d)} = "1" ]; then
		cp ${WORKDIR}/u-boot-cap.* ${DEPLOYDIR}

		if [ ${@bb.utils.contains("DISTRO_FEATURES", "secure-boot", "1", "0", d)} = "0" ]; then
			dtc -I dts -O dtb -o ${B}/secure-cap.dtbo ${WORKDIR}/secure-cap.dts
			fdtoverlay -i ${B}/${UBOOT_DTB_BINARY} -o ${B}/${UBOOT_DTB_BINARY} -v ${B}/secure-cap.dtbo

			# Combine u-boot-nodtb binary with u-boot dtb binary for secure capsule
			cat ${B}/${UBOOT_NODTB_BINARY} ${B}/${UBOOT_DTB_BINARY} > ${B}/${UBOOT_BINARY}
		fi
	fi

	# Sometimes the boot.script.bin might not exist since artifacts of do_install
	# have been cached and won't be regenerated. In this case, we need to check
	# existence and regenerate it if necessary.
	if [ ! -e "${WORKDIR}/boot.script.bin" ]; then
		cd ${WORKDIR}
		${UBOOT_MKIMAGE_CMD} -f ${WORKDIR}/boot.script.its ${WORKDIR}/boot.script.bin
	fi
	# Append boot script binary to the end of u-boot binary
	cat ${B}/${UBOOT_BINARY} ${WORKDIR}/boot.script.bin > ${DEPLOYDIR}/${UBOOT_IMAGE}
}

do_add_env_to_dtb() {
	if [ ${@bb.utils.contains("DISTRO_FEATURES", "secure-boot", "1", "0", d)} = "1" ]; then
		do_uboot_env "u-boot.dtb"
	fi
}

addtask add_env_to_dtb before do_install after do_compile

do_deploy:append:i300-pumpkin() {
	sed -i '/^check_fastboot_entry=.*/c\check_fastboot_entry=gpio input 42; if test $? -eq 0; then setenv fastboot_entry 1; else setenv fastboot_entry 0; fi' ${DEPLOYDIR}/u-boot-initial-env
}

inherit deploy

SYSROOT_DIRS += " /boot"
