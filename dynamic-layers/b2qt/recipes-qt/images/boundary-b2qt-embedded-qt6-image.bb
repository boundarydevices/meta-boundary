# This image extends b2qt-embedded-qt5-image with additional
# Boundary Devices packages

require recipes-qt/images/b2qt-embedded-qt6-image.bb

IMAGE_INSTALL_WIFI_BT ?= "${IMAGE_INSTALL_WIFI_BT_PKGS}"
IMAGE_INSTALL_WIFI_BT_PKGS = " \
        bdsdmac-firmware \
        if573-sdio-firmware \
        lwb5plus-sdio-sa-firmware \
        nx61x-firmware \
        kernel-module-bdsdmac-backports \
"

IMAGE_INSTALL += " \
	can-utils \
	e2fsprogs \
	evtest \
	firmwared \
	fw-env-rules \
	i2c-tools \
	iperf3 \
	iproute2 \
	libdrm-tests \
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
	${IMAGE_INSTALL_WIFI_BT} \
"
