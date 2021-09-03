SUMMARY = "silex uart attach service"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
LICENSE = "MIT"

SRC_URI = "file://silex-uart.service \
	   file://silex-uart.sh \
"

SRC_URI:append:mx6   = "file://silex-imx6.conf"
SRC_URI:append:mx7   = "file://silex-imx7.conf"
SRC_URI:append:mx8mq  = "file://silex-imx8m.conf"
SRC_URI:append:mx8mp  = "file://silex-imx8mp.conf"
SRC_URI:append:mx8mm = "file://silex-imx8mm.conf"
SRC_URI:append:mx8mn = "file://silex-imx8mn.conf"

SILEX_CONF_mx6   = "silex-imx6.conf"
SILEX_CONF_mx7   = "silex-imx7.conf"
SILEX_CONF_mx8mq  = "silex-imx8m.conf"
SILEX_CONF_mx8mp  = "silex-imx8mp.conf"
SILEX_CONF_mx8mm = "silex-imx8mm.conf"
SILEX_CONF_mx8mn = "silex-imx8mn.conf"

inherit systemd

do_install:append() {

    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/silex-uart.service ${D}${systemd_unitdir}/system
    fi

	install -d ${D}/${sysconfdir}/bluetooth/
	install -m 0644 ${WORKDIR}/${SILEX_CONF} ${D}/${sysconfdir}/bluetooth/silex.conf

	install -d ${D}${datadir}/silex-uart/
	install -m 755 ${WORKDIR}/silex-uart.sh ${D}${datadir}/silex-uart/
}

FILES_${PN} += "/usr/share/silex-uart/*"

SYSTEMD_SERVICE_${PN} = "silex-uart.service "
SYSTEMD_AUTO_ENABLE = "disable"
