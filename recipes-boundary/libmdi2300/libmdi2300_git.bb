SUMMARY = "Library for Opticon MDI-2300 Barcode scanner."
HOMEPAGE = "https://github.com/boundarydevices/libmdi2300"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e8d8feac5daeb0b39a13e1c1535e1f20"
SECTION = "libs"

SRCREV = "dce5071fc8e1ac1e87cce0920b975a8cf33cdecc"
SRC_URI = "git://github.com/boundarydevices/libmdi2300.git;protocol=git;"

S = "${WORKDIR}/git/"

PACKAGES = "${PN} ${PN}-dbg ${PN}-examples"

EXTRA_OEMAKE = " 'CC=${CC}' "

do_compile () {
        oe_runmake all
        oe_runmake examples
}

do_install () {
        oe_runmake install DESTDIR=${D}/usr/
        oe_runmake install_examples DESTDIR=${D}/usr/
}

FILES_${PN} += "/usr/lib/ /usr/include"
FILES_${PN}-dbg += "/usr/src/"
FILES_${PN}-examples += "/usr/bin/"

BBCLASSEXTEND = "native"
