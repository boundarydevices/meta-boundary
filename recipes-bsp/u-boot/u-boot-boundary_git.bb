DESCRIPTION = "U-Boot for Ezurio Nitrogen boards"
LICENSE = "GPL-2.0-or-later"

require recipes-bsp/u-boot/u-boot.inc

inherit deploy ${@oe.utils.ifelse(d.getVar('UBOOT_PROVIDES_BOOT_CONTAINER') == '1', 'imx-boot-container', '')}

SRC_URI = "git://github.com/boundarydevices/u-boot.git;branch=${SRCBRANCH};protocol=https"
SRC_URI += "file://fw_env.config"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"
LIC_FILES_CHKSUM:nitrogen91 = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"
LIC_FILES_CHKSUM:nitrogen93 = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"
LIC_FILES_CHKSUM:nitrogen95 = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"
LIC_FILES_CHKSUM:porpoise = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

PV = "v2022.04+git${SRCPV}"
PV:nitrogen91 = "v2024.04+git${SRCPV}"
PV:nitrogen93 = "v2024.04+git${SRCPV}"
PV:nitrogen95 = "v2024.04+git${SRCPV}"
PV:porpoise  = "v2024.04+git${SRCPV}"

SRCBRANCH = "boundary-v2022.04"
SRCBRANCH:nitrogen91 = "ezurio-lf_v2024.04"
SRCBRANCH:nitrogen93 = "ezurio-lf_v2024.04"
SRCBRANCH:nitrogen95 = "ezurio-lf_v2024.04"
SRCBRANCH:porpoise  = "ezurio-lf_v2024.04"

SRCREV = "022ec9bc33131d26db56cceee6272e65dd3ee62f"
SRCREV:nitrogen91 = "8e1aa8bfbc109fbfd64bb9dac80aa8ad628191eb"
SRCREV:nitrogen93 = "8e1aa8bfbc109fbfd64bb9dac80aa8ad628191eb"
SRCREV:nitrogen95 = "8e1aa8bfbc109fbfd64bb9dac80aa8ad628191eb"
SRCREV:porpoise  = "8e1aa8bfbc109fbfd64bb9dac80aa8ad628191eb"

DEPENDS += "bison-native dtc-native python3-setuptools-native"

PROVIDES += "u-boot"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(nitrogen8m|nitrogen8mm|nitrogen8mn|nitrogen8mp|nitrogen8ulp|nitrogen91|nitrogen93|nitrogen95|porpoise)"
