CUSTOM_DEFCONFIG ?= ""
CUSTOM_DEFCONFIG_imx6-acl = "${WORKDIR}/defconfig-acl"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://defconfig-acl "

SRCREV = "fc4f6c46d65e0ef16d57f192ddd1c42e1d817a11"

do_custom_defconfig () {
  if [ ! -z "${CUSTOM_DEFCONFIG}" ]; then 
		cp ${CUSTOM_DEFCONFIG} ${WORKDIR}/defconfig
	fi
}
addtask do_custom_defconfig after do_patch before do_compile

COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|imx6-acl)"
