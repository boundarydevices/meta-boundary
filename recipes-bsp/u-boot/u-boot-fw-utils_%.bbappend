FILESEXTRAPATHS_prepend_mx6 := "${THISDIR}/boundary:"
FILESEXTRAPATHS_prepend_mx7 := "${THISDIR}/boundary:"

SRC_URI += "\
	file://fw_env.config \
"

do_install_append () {
	rm ${D}${sysconfdir}/fw_env.config
	install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}
