inherit qt4e

DESCRIPTION = "QT Browser"
PR = "r0"
LICENSE = "CLOSED"

DEPENDS = "qt4-embedded"
SRCREV = "914cda616892fd6b46bf72105370b4a6aa8c05ac"
SRC_URI = "git://github.com/boundarydevices/qtbrowser;branch=master \
	file://run-app \
	file://stop-app \
"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""


do_install() {
    export INSTALL_ROOT=${D}
    make install
}

do_install_append() {
	install -d ${D}/app/
	install -m 755 ${WORKDIR}/run-app ${D}/app
	install -m 755 ${WORKDIR}/stop-app ${D}/app
}

FILES_${PN} = " \
	/usr/bin/* \
	/app/run-app \
	/app/stop-app \
"
