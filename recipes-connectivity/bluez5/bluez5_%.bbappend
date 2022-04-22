FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PATCHES = " file://0001-hciattach-add-QCA9377-Tuffello-support.patch \
"

SRC_URI:append:mx6-nxp-bsp = "${PATCHES}"
SRC_URI:append:mx7-nxp-bsp = "${PATCHES}"
SRC_URI:append:mx8-nxp-bsp = "${PATCHES}"

PACKAGE_ARCH_mx6 = "${MACHINE_SOCARCH}"
PACKAGE_ARCH_mx7 = "${MACHINE_SOCARCH}"
PACKAGE_ARCH_mx8 = "${MACHINE_SOCARCH}"
