FILESEXTRAPATHS_prepend_mx6 := "${THISDIR}/files/arm:"
FILESEXTRAPATHS_prepend_mx7 := "${THISDIR}/files/arm:"
FILESEXTRAPATHS_prepend_mx8 := "${THISDIR}/files/arm64:"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;protocol=https;branch=${SRCBRANCH} \
"

LOCALVERSION = "-2.0.0-ga+yocto"
SRCREV = "${AUTOREV}"
COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm)"

S = "${WORKDIR}/git"

do_merge_default_config() {

    if [ -f ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} ]; then
	# create config with make config
	oe_runmake  -C ${S} O=${KBUILD_OUTPUT} ${KERNEL_DEFCONFIG}
	cp ${KBUILD_OUTPUT}/.config ${WORKDIR}/defconfig
    fi

}
addtask merge_default_config before do_preconfigure after do_patch
