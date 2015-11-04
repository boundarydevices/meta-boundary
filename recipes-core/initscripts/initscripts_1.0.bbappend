FILESEXTRAPATHS_prepend_nitrogen6x := "${THISDIR}/boundary:"
FILESEXTRAPATHS_prepend_nitrogen6x-lite := "${THISDIR}/boundary:"

SRC_URI_append_mx6 = " file://blank-displays \
        file://g_ether \
        file://wifi \
"

inherit update-alternatives
DEPENDS_append = " update-rc.d-native"

do_install_append_mx6 () {
	install -m 0755    ${WORKDIR}/blank-displays	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/g_ether   	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/wifi      	${D}${sysconfdir}/init.d
	
	update-rc.d -r ${D} blank-displays start 85 0 .
        update-rc.d -r ${D} g_ether start 50 5 .
	update-rc.d -r ${D} wifi start 50 5 .
}

MASKED_SCRIPTS += " \
  blank-displays \
  g_ether \
  wifi \
"

