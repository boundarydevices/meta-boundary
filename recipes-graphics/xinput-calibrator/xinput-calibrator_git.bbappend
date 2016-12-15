# Remove xinput_calibrator autostart. Our displays are already calibrated.
# Leaves binary in place in case they want to run it anyway manually

do_install_append(){
	rm -rf ${D}${sysconfdir}/
}

FILES_${PN}_remove += "${sysconfdir}/xdg/autostart"
