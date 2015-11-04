# Copyright (C) 2014 Boundary Devices

SUMMARY = "app-startup"
SECTION = "base"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://app;beginline=11;endline=11;md5=1c2ccc7e2f30e48720e36f0c0e5d1b79"

S = "${WORKDIR}"

SRC_URI = " \
        file://app \
        file://root.profile \
"

do_install_append() {
        install -d ${D}${sysconfdir}/init.d/
        install -d ${D}/home/root/
        install -m 755 ${S}/app ${D}${sysconfdir}/init.d/
        install ${S}/root.profile ${D}/home/root/.profile
	update-rc.d -r ${D} app start 80 5 .
}

FILES_${PN} += " \
        ${sysconfdir}/init.d/app \
        /home/root/.profile \
"

