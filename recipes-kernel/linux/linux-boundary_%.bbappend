CUSTOM_DEFCONFIG ?= ""

do_custom_defconfig () {
  if [ ! -z "${CUSTOM_DEFCONFIG}" ]; then 
		cp ${CUSTOM_DEFCONFIG} ${WORKDIR}/defconfig
	fi
}
addtask do_custom_defconfig after do_patch before do_compile

COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|imx6-acl)"
