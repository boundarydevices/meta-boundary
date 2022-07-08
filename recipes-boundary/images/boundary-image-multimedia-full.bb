# This image extends fsl-image-multimedia-full with additional
# Boundary Devices packages

require recipes-fsl/images/fsl-image-multimedia-full.bb

CORE_IMAGE_EXTRA_INSTALL += " \
	can-utils \
	crda \
	e2fsprogs \
	evtest \
	i2c-tools \
	imx-gpu-viv-demos \
	iperf3 \
	iproute2 \
	kernel-module-qcacld \
	libdrm-tests \
	linux-firmware-bdsdmac \
	minicom \
	mmc-utils \
	modemmanager \
	networkmanager \
	networkmanager-nmcli \
	openssh \
	packagegroup-fsl-isp \
	packagegroup-fsl-ml \
	packagegroup-fsl-opencv-imx \
	packagegroup-tools-bluetooth \
	pciutils \
	psplash \
	screen \
	silex-uart \
	spitools \
	strace \
	tslib-tests tslib-calibrate \
	u-boot-boundary-env \
	u-boot-fw-utils \
	udev-rules-bt \
	udev-rules-imx \
	v4l-utils \
	wireless-regdb \
"

#imx-gpu-viv-demos are not compatible with i.MX7
IMAGE_INSTALL:remove:mx7-nxp-bsp += " imx-gpu-viv-demos"

#Temporarily remove clutter demos, as there is a build error in cogl-1.0
PACKAGE_IMX_TO_REMOVE_imxgpu2d = "clutter-1.0-examples clutter-1.0 clutter-gst-3.0 gtk+3-demo"
PACKAGE_IMX_TO_REMOVE_imxgpu3d = "clutter-1.0-examples clutter-1.0 clutter-gst-3.0"

#FIX ME: build failing on 8mn, temporarily remove from image
IMAGE_INSTALL:remove:mx8mn-nxp-bsp += " packagegroup-fsl-ml"
