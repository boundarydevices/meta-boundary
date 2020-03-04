# This image extends meta-b2qt-embedded-qbsp with additional
# Boundary Devices packages

require recipes-qt/meta/meta-b2qt-embedded-qbsp.bb

IMAGE_INSTALL += " \
	i2c-tools \
	iperf3 \
	imx-gpu-viv-demos \
	mmc-utils \
	openssh \
	spitools \
	tslib-tests tslib-calibrate \
	evtest \
	udev-rules-bt \
	silex-uart \
"

QBSP_IMAGE_TASK = "boundary-b2qt-embedded-qt5-image"
