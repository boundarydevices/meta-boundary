DESCRIPTION = "microcom is a small minicom-like serial terminal emulator with scripting support."
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRCREV = "5ea09fd573a56efeba3c2cc07e41537d52d3de48"
SRC_URI = "git://github.com/Oliviers-OSS/microcom;branch=master"

S = "${WORKDIR}/git"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 microcom ${D}${bindir}
}

inherit autotools
