SUMMARY = "silex uart attach service"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

LICENSE = "MIT"


SRC_URI = "file://silex-uart.service \
	   file://silex.conf \
	   file://silex-uart.sh \
"

inherit systemd


do_install_append() {

    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/silex-uart.service ${D}${systemd_unitdir}/system
    fi

	install -d ${D}/${sysconfdir}/bluetooth/
	install -m 0644 ${WORKDIR}/silex.conf ${D}/${sysconfdir}/bluetooth/

	install -d ${D}${datadir}/silex-uart/
	install -m 755 ${WORKDIR}/silex-uart.sh ${D}${datadir}/silex-uart/
}

FILES_${PN} += "/usr/share/silex-uart/*"

SYSTEMD_SERVICE_${PN} = "silex-uart.service "
SYSTEMD_AUTO_ENABLE = "enable"
