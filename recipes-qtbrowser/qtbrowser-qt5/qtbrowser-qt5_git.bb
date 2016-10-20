require recipes-qt/qt5/qt5.inc

DESCRIPTION = "QT Browser"
PR = "r0"
LICENSE = "CLOSED"

DEPENDS = "qtbase qtwebkit"

SRCREV = "57ac373f948498810c3f276fe712e67f5ec0d4aa"
SRC_URI = "git://github.com/boundarydevices/qtbrowser;branch=qt5"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""


do_install() {
    export INSTALL_ROOT=${D}
    make install
}

FILES_${PN} = " \
	/usr/bin/* \
"
