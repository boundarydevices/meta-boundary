FILESEXTRAPATHS_prepend_mx6 := "${THISDIR}/boundary:"

SRC_URI_append_mx6 = " \
        file://dropbear \
        file://dropbear_rsa_host_key \
"

do_install_append_mx6 () {
        install -d ${D}${sysconfdir}/default
        install -d ${D}/app/etc/

	install -m 0755    ${WORKDIR}/dropbear	                ${D}${sysconfdir}/default/
 	install -m 0755    ${WORKDIR}/dropbear_rsa_host_key     ${D}/app/etc/
}

FILES_${PN} += " \
        ${sysconfdir}/default/dropbear \
        /app/etc/dropbear* \
"
