# This image extends fsl-image-multimedia-full with additional
# Boundary Devices packages

require recipes-fsl/images/fsl-image-multimedia-full.bb

CORE_IMAGE_EXTRA_INSTALL += " \
	i2c-tools \
	iperf3 \
	imx-gpu-viv-demos \
	kernel-module-qcacld \
	linux-firmware-bdsdmac \
	mmc-utils \
	openssh \
	spitools \
	networkmanager \
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
"

#imx-gpu-viv-demos are not compatible with i.MX7
IMAGE_INSTALL_remove_mx7 += " imx-gpu-viv-demos"

#Temporarily remove clutter demos, as there is a build error in cogl-1.0
PACKAGE_IMX_TO_REMOVE_imxgpu2d = "clutter-1.0-examples clutter-1.0 clutter-gst-3.0 gtk+3-demo"
PACKAGE_IMX_TO_REMOVE_imxgpu3d = "clutter-1.0-examples clutter-1.0 clutter-gst-3.0"
