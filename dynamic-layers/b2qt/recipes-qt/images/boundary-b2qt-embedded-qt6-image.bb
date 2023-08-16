# This image extends b2qt-embedded-qt5-image with additional
# Boundary Devices packages

require recipes-qt/images/b2qt-embedded-qt6-image.bb

IMAGE_INSTALL += " \
	kernel-module-qcacld \
	linux-firmware-bdsdmac \
	linux-firmware-cypress \
	i2c-tools \
	iperf3 \
	imx-gpu-viv-demos \
	mmc-utils \
	spitools \
	tslib-tests tslib-calibrate \
	evtest \
	silex-uart \
	udev-rules-bt \
	can-utils \
	iproute2 \
	pciutils \
	e2fsprogs \
	packagegroup-tools-bluetooth \
	libdrm-tests \
	v4l-utils \
	strace \
	modemmanager \
	screen \
	psplash \
	packagegroup-fsl-isp \
	packagegroup-fsl-opencv-imx \
	packagegroup-fsl-ml \
"

#FIX ME: build failing on 8mn, temporarily remove from image
IMAGE_INSTALL:remove:mx8mn-nxp-bsp += " packagegroup-fsl-ml"

#imx-gpu-viv-demos are not compatible with i.MX7
IMAGE_INSTALL:remove:mx7-nxp-bsp += " imx-gpu-viv-demos"
