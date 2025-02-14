FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://p2p_blacklist.conf \
"

do_install:append() {
	install -d ${D}${sysconfdir}/NetworkManager/conf.d/
	install -m 0755 ${WORKDIR}/p2p_blacklist.conf ${D}${sysconfdir}/NetworkManager/conf.d/p2p_blacklist.conf
}
