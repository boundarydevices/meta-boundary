DESCRIPTION = "U-Boot for Boundary Devices boards"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"

SRCREV = "0fc0dd5a99d4c089a921a717f7ce3e7c2a7e7acf"
SRCBRANCH = "boundary-v2020.10"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
