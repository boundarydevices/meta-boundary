SUMMARY = "Test/Debug tools for thermal printers."
HOMEPAGE = "https://github.com/boundarydevices/printer-tools"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4bc53cea4911b2abe17c307d0f49a5d8"
SECTION = "base"

SRCREV = "49dc7ff7b9657d9310cb49cfae77c9c2b2422ffe"
SRCBRANCH = "ftp628"
SRC_URI = "git://github.com/boundarydevices/printer-tools.git;protocol=git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git/"

DEPENDS += " libpng "

EXTRA_OEMAKE = " 'CC=${CC}' 'CFLAGS=-I${STAGING_INCDIR}' \
		'LDFLAGS=-L${STAGING_LIBDIR}' "

do_compile () {
        oe_runmake all
}

do_install () {
        oe_runmake install DESTDIR=${D}/usr/
}

FILES_${PN} += "/usr/bin"

INSANE_SKIP_${PN} = "ldflags"

BBCLASSEXTEND = "native"
