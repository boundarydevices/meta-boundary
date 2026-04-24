# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Ezurio Nitrogen boards"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.6.52"

SRC_URI = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https \
"

LINUX_VERSION_EXTENSION = "+yocto"
SRCBRANCH = "ezurio-lf-6.6.y"
SRCREV = "c8c012723f8ade6e1121fc60a4ba92058b4efb65"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(nitrogen8m|nitrogen8mm|nitrogen8mn|nitrogen8mp|nitrogen8ulp|nitrogen91|nitrogen93|nitrogen95|porpoise)"

KBUILD_DEFCONFIG ?= "ezurio_defconfig"

S = "${WORKDIR}/git"

# In case of 8mp, kernel-module-isp-vvcam will build and cause the following error:
# The recipe linux-boundary is trying to install files into a shared area when those files already exist (kernel-module-imx219)
# So we need to remove config from kernel to avoid error.
EXTRA_OEMAKE:append:mx8mp-nxp-bsp = " CONFIG_VIDEO_IMX219=n"
