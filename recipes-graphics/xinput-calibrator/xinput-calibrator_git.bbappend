# Remove xinput_calibrator autostart. Our displays are already calibrated.
# Leaves binary in place in case they want to run it anyway manually

do_install:append(){
	rm -rf ${D}${sysconfdir}/
}

FILES_${PN}:remove += "${sysconfdir}/xdg/autostart"
