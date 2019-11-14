# This image extends b2qt-embedded-qt5-image with additional
# Boundary Devices packages

require recipes-qt/images/b2qt-embedded-qt5-image.bb

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
