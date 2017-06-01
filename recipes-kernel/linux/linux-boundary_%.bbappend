CUSTOM_DEFCONFIG ?= ""
CUSTOM_DEFCONFIG_imx6-acl = "${WORKDIR}/defconfig-acl"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://defconfig-acl "

SRCREV = "ff461ec0112d5151a65a988e6e3106dcf9dae236"

do_custom_defconfig () {
	if [ ! -z "${CUSTOM_DEFCONFIG}" ]; then
		cp ${CUSTOM_DEFCONFIG} ${WORKDIR}/defconfig
	fi
}
addtask do_custom_defconfig after do_unpack before do_preconfigure

COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|imx6-acl)"
