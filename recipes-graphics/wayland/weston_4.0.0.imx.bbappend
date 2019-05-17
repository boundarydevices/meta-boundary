FILESEXTRAPATHS_prepend  := "${THISDIR}/weston:"

SRC_URI_append = "${@bb.utils.contains('MACHINE', 'nitrogen8mm', "file://8mm/weston.ini", "", d)}"
SRC_URI_append = "${@bb.utils.contains('MACHINE', 'nitrogen8m',  "file://8mq/weston.ini", "", d)}"

do_install_append_mx8mq() {

	# install default weston.ini
	install -D -m 0644 ${WORKDIR}/8mq/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}

do_install_append_mx8mm() {

	# install default weston.ini
	install -D -m 0644 ${WORKDIR}/8mm/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}

