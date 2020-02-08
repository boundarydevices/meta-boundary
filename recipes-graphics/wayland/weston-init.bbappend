FILESEXTRAPATHS_prepend  := "${THISDIR}/weston:"

SRC_URI_append = " file://weston.ini"

do_install_append_mx8() {

	install -D -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}



