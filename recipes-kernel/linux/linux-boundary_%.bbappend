FILESEXTRAPATHS_prepend := "${THISDIR}/files/arm64:"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
           file://defconfig \
"

LOCALVERSION = "-2.0.0-ga+yocto"
SRCBRANCH = "boundary-imx_4.14.x_2.0.0_ga"
SRCREV = "${AUTOREV}"
COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm)"
