# Copyright (C) 2014 Boundary Devices

SUMMARY = "Devregs"
SECTION = "base"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=5003fa041d799dd5dd5f646b74e36924"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/boundarydevices/devregs.git;branch=${SRCBRANCH}"
SRCBRANCH = "master"
SRCREV = "4fffb7de640a1fe56d4ce18fffe74dfaec31f81a"

inherit autotools-brokensep

do_install_append() {
        cp -fv ${S}/dat/devregs_imx6* ${D}${sysconfdir}/
}

FILES_${PN} += " \
        ${sysconfdir}/devregs_imx6*.dat \
"
