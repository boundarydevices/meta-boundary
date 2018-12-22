# Copyright (C) 2014 Boundary Devices

SUMMARY = "Devregs"
SECTION = "base"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=5003fa041d799dd5dd5f646b74e36924"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/boundarydevices/devregs.git;branch=${SRCBRANCH}"
SRCBRANCH = "master"
SRCREV = "24723266f8816f521053ee685531e4178292568d"

inherit autotools-brokensep

do_install_append() {
        cp -fv ${S}/dat/devregs_imx* ${D}${sysconfdir}/
}

FILES_${PN} += " \
        ${sysconfdir}/devregs_imx*.dat \
"
