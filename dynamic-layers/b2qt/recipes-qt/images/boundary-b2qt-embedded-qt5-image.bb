# This image extends b2qt-embedded-qt5-image with additional
# Boundary Devices packages

require recipes-qt/images/b2qt-embedded-qt5-image.bb

IMAGE_INSTALL += " \
	i2c-tools \
	iperf3 \
	imx-gpu-viv-demos \
	mmc-utils \
	spitools \
	tslib-tests tslib-calibrate \
	evtest \
	silex-uart \
"

#imx-gpu-viv-demos are not compatible with i.MX7
IMAGE_INSTALL_remove_mx7 += " imx-gpu-viv-demos"
