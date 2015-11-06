require recipes-qt/qt5/qt5.inc

DESCRIPTION = "QT Browser"
PR = "r0"
LICENSE = "CLOSED"

DEPENDS = "qtbase qtwebkit"

SRCREV = "e2ca0767b744c8e8a26b72b496b729e855462d3c"
SRC_URI = "git://github.com/boundarydevices/qtbrowser;branch=qt5 \
"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""


do_install() {
    export INSTALL_ROOT=${D}
    make install
}

FILES_${PN} = " \
	/usr/bin/* \
"
