# This image extends b2qt-embedded-qt5-image with additional
# Boundary Devices packages

require recipes-qt/images/b2qt-embedded-qt6-image.bb

IMAGE_INSTALL_QCA ?= "${IMAGE_INSTALL_QCA_PKGS}"
IMAGE_INSTALL_QCA_PKGS = " \
    kernel-module-qcacld \
    linux-firmware-bdsdmac \
"
IMAGE_INSTALL_QCA_PKGS:mx93-nxp-bsp = ""

IMX_GPU_VIV_DEMOS ?= "imx-gpu-viv-demos"
# imx-gpu-viv-demos are not compatible with i.MX7 and i.MX9
IMX_GPU_VIV_DEMOS:mx7-nxp-bsp = ""
IMX_GPU_VIV_DEMOS:mx93-nxp-bsp = ""

IMAGE_INSTALL += " \
	can-utils \
	e2fsprogs \
	evtest \
	i2c-tools \
	iperf3 \
	iproute2 \
	libdrm-tests \
	linux-firmware-cypress \
	memtester \
	minicom \
	mmc-utils \
	modemmanager \
	packagegroup-fsl-isp \
	packagegroup-fsl-opencv-imx \
	packagegroup-imx-ml \
	packagegroup-tools-bluetooth \
	pciutils \
	psplash \
	screen \
	spitools \
	strace \
	tslib-tests tslib-calibrate \
	u-boot-boundary-env \
	u-boot-fw-utils \
	udev-rules-imx \
	v4l-utils \
	wireless-regdb-static \
	${IMAGE_INSTALL_QCA} \
"
