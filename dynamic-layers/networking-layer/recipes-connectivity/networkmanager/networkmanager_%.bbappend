FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://NetworkManager.conf \
"

do_install:append() {

	install -m 755 ${WORKDIR}/NetworkManager.conf ${D}/etc/NetworkManager

}

