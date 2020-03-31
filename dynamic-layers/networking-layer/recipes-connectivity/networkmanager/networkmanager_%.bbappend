FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
	file://NetworkManager.conf \
"

do_install_append() {

	install -m 755 ${WORKDIR}/NetworkManager.conf ${D}/etc/NetworkManager

}

