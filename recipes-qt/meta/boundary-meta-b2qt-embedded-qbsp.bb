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
	networkmanager \
	tslib-tests tslib-calibrate \
"
