DESCRIPTION = "U-Boot for Boundary Devices boards"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"
LIC_FILES_CHKSUM:nitrogen93 = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"
LIC_FILES_CHKSUM:porpoise = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

PV = "v2022.04+git${SRCPV}"
PV:nitrogen93 = "v2023.04+git${SRCPV}"
PV:porpoise  = "v2024.04+git${SRCPV}"

SRCREV = "ae95e6c8f4474a1d5345913cae4da9f58f0f2c41"
SRCREV:nitrogen93 = "73dcd1c420337fb86b1cfa480b82c9fe5bf620a7"
SRCREV:porpoise  = "6068a439a51c97564818d6ba19c68637273dea25"

SRCBRANCH = "boundary-v2022.04"
SRCBRANCH:nitrogen93 = "boundary-lf_v2023.04"
SRCBRANCH:porpoise  = "ezurio-lf_v2024.04-pass2"

SRC_URI = "git://github.com/boundarydevices/u-boot.git;branch=${SRCBRANCH};protocol=https"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
PACKAGE_ARCH = "${MACHINE_ARCH}"
