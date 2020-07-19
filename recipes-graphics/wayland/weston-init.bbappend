FILESEXTRAPATHS_prepend  := "${THISDIR}/weston:"

SRC_URI_append_mx6 = " file://weston.ini"

do_install_append_mx6() {

	install -D -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}

#Disable weston init.d script, as this will cause two instances of weston to run
INITSCRIPT_PARAMS = "stop 20 0 1 6 ."
