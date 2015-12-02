FILESEXTRAPATHS_append := "${THISDIR}/files:"
SRC_URI_append = " \
	file://calibrate-ft5x06.sh \
"

do_install_append_nitrogen6x(){
	rm -rf ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/calibrate-ft5x06.sh ${D}${sysconfdir}/init.d
	update-rc.d -r ${D} calibrate-ft5x06.sh start 91 5 .
}
do_install_append_nitrogen6x-lite(){
	rm -rf ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/calibrate-ft5x06.sh ${D}${sysconfdir}/init.d
	update-rc.d -r ${D} calibrate-ft5x06.sh start 91 5 .
}
do_install_append_nitrogen6sx(){
	rm -rf ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/calibrate-ft5x06.sh ${D}${sysconfdir}/init.d
	update-rc.d -r ${D} calibrate-ft5x06.sh start 91 5 .
}

FILES_nitrogen6x_remove += "${sysconfdir}/xdg/autostart"
FILES_nitrogen6x-lite_remove += "${sysconfdir}/xdg/autostart"
FILES_nitrogen6sx_remove += "${sysconfdir}/xdg/autostart"
