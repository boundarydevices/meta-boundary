# Copyright (C) 2015 Boundary Devices

SUMMARY = "sysklogd-config-remote"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5003fa041d799dd5dd5f646b74e36924"

S = "${WORKDIR}"

SRC_URI = " \
        file://syslogd \
        file://COPYING \
"

do_install_append() {
        install -d ${D}${sysconfdir}/default
        install ${S}/syslogd ${D}${sysconfdir}/default/
}

FILES_${PN} += " \
        ${sysconfdir}/default/syslogd \
"

