SUMMARY = "U-boot scripts for Nitrogen platforms"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit deploy

DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://boot.cmd file://upgrade.cmd"

do_compile() {
        mkimage -A arm64 -T script -C none -n "Boot script" -d "${WORKDIR}/boot.cmd" ${WORKDIR}/boot.scr
        mkimage -A arm64 -T script -C none -n "Upgrade script" -d "${WORKDIR}/upgrade.cmd" ${WORKDIR}/upgrade.scr
}

do_install() {
	install -d -m 0755 ${D}/boot
	install -m 0755 ${WORKDIR}/boot.scr ${D}/boot
	install -m 0755 ${WORKDIR}/upgrade.scr ${D}/boot
}

do_deploy() {
	install -D -m 644 ${D}/boot/boot.scr \
		${DEPLOYDIR}/boot.scr-${MACHINE}
	install -D -m 644 ${D}/boot/upgrade.scr \
		${DEPLOYDIR}/upgrade.scr-${MACHINE}
}

addtask deploy after do_install

FILES:${PN} = "/boot /boot/boot.scr /boot/upgrade.scr"
