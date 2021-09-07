FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://default.pa"

do_install:append() {

	install -m 0644 ${WORKDIR}/default.pa ${D}${sysconfdir}/pulse/default.pa
}
