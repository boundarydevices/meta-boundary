SUMMARY = "U-boot boot script for Tungsten 700"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://boot.cmd"

do_compile() {
    mkimage -A arm64 -T script -C none -n "Boot script" -d "${WORKDIR}/boot.cmd" ${WORKDIR}/boot.scr
}

do_install:append() {
	install -d -m 0755 ${D}/boot
	install -m 0755 ${WORKDIR}/boot.scr ${D}/boot
}

FILES:${PN} = "/boot /boot/boot.scr"
