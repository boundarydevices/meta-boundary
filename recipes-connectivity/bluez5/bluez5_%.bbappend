FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PATCHES = " file://0001-hciattach-add-QCA9377-Tuffello-support.patch \
"

SRC_URI_append_mx6 = "${PATCHES}"
SRC_URI_append_mx7 = "${PATCHES}"

PACKAGE_ARCH_mx6 = "${MACHINE_SOCARCH}"
PACKAGE_ARCH_mx7 = "${MACHINE_SOCARCH}"
