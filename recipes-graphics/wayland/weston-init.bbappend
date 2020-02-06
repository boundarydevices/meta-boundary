FILESEXTRAPATHS_prepend  := "${THISDIR}/weston:"

SRC_URI_append = "${@bb.utils.contains('MACHINE', 'nitrogen8mm', "file://mx8mm/weston.ini", "", d)}"
SRC_URI_append = "${@bb.utils.contains('MACHINE', 'nitrogen8m',  "file://mx8mq/weston.ini", "", d)}"

do_install_append_mx8mm() {

	# install default weston.ini
	install -D -m 0644 ${WORKDIR}/mx8mm/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}

