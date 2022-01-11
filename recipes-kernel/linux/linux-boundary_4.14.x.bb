# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Boundary Devices boards"

FILESEXTRAPATHS_prepend_mx6 := "${THISDIR}/${PN}-${PV}/arm:"
FILESEXTRAPATHS_prepend_mx7 := "${THISDIR}/${PN}-${PV}/arm:"
FILESEXTRAPATHS_prepend_mx8 := "${THISDIR}/${PN}-${PV}/arm64:"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;protocol=https;branch=${SRCBRANCH} \
           file://defconfig \
"

LOCALVERSION = "-2.0.0-ga+yocto"
SRCBRANCH = "boundary-imx_4.14.x_2.0.0_ga"
SRCREV = "${AUTOREV}"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m)"

KERNEL_DEFCONFIG = "boundary_defconfig"
