FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://NetworkManager.conf \
"

do_install:append() {
	install -d ${D}${sysconfdir}/NetworkManager/
	install -m 0755 ${WORKDIR}/NetworkManager.conf ${D}${sysconfdir}/NetworkManager/NetworkManager.conf
}
