SUMMARY = "Calibrates xinput to the screen resolution of the screen for ft5x06 screens"
LICENSE = "boundary"
LIC_FILES_CHKSUM = "file://COPYING;md5=f8feab0e4c9f5cb63f46f45e5e9cb7ab"

S = "${WORKDIR}"

SRC_URI = " \
	file://COPYING \
	file://calibrate-ft5x06.sh \
"

do_install () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/calibrate-ft5x06.sh ${D}${sysconfdir}/init.d
	update-rc.d -r ${D} calibrate-ft5x06.sh start 91 5 .
}
