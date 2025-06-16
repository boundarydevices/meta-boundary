DESCRIPTION = "udev rules to allow for reading and modifying U-Boot environment (fw_setenv and fw_printenv)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " file://fw-env.rules"

S = "${UNPACKDIR}"

do_install () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${UNPACKDIR}/fw-env.rules ${D}${sysconfdir}/udev/rules.d/
}
