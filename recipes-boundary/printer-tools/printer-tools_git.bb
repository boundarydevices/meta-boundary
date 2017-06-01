SUMMARY = "Test/Debug tools for thermal printers."
HOMEPAGE = "https://github.com/boundarydevices/printer-tools"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4bc53cea4911b2abe17c307d0f49a5d8"
SECTION = "base"

SRCREV = "e219aea844d720e7b03da495862cc1586132e7dd"
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
