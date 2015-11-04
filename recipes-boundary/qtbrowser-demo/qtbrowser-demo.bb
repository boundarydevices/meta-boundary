DESCRIPTION = "An image that will launch into the demo application (qtbrowser) for the embedded (not based on X11) version of Qt."
LICENSE = "boundary"
PR = "r0"
LIC_FILES_CHKSUM = "file://COPYING;md5=f8feab0e4c9f5cb63f46f45e5e9cb7ab"
IMAGE_FSTYPES = "boundary ext3"

SRC_URI = " \
	file://COPYING \
"

IMAGE_INSTALL += "\
	${CORE_IMAGE_BASE_INSTALL} \
	packagegroup-core-qt4e \
	app-startup \
	packagegroup-fsl-gstreamer-full \
	iperf \
	flex \
	gcc \
	gdb \
	git \
	m4 \
	make \
	libtool \
	python-compiler \
	daemonize \
	dosfstools \
	nodejs \
	qtbrowser \
"

set_root_passwd() {
	sed 's%^root:[^:]*:%root:$6$wd9rU/snGiA$6it4ywCV2hu.A3ZcbaVOriJHJNYMacUcKPtiKMUvHKuD.YPvHwYL4igiirKtU9X2mdmq8zaPf8EKDmTiIiZr8.:%' \
		< ${IMAGE_ROOTFS}/etc/shadow \
		> ${IMAGE_ROOTFS}/etc/shadow.new;
	mv ${IMAGE_ROOTFS}/etc/shadow.new ${IMAGE_ROOTFS}/etc/shadow ;
}

ROOTFS_POSTPROCESS_COMMAND += "set_root_passwd; "


inherit core-image
