SUMMARY = "WiFi and BT firmware files for BD-SDMAC module"
SECTION = "kernel"

LICENSE = "Firmware-qca"

LIC_FILES_CHKSUM = "\
    file://LICENSE.qca_firmware;md5=e8b1e9e8ce377ca5b2c1098e5690f470 \
"

SRCREV = "5e4b71211ecbb79e7693d2ee07361847f5a0cb40"

SRC_URI = "git://github.com/boundarydevices/qca-firmware.git;protocol=https;branch=${SRCBRANCH}"
SRCBRANCH = "bd-sdmac-qcacld"

S = "${WORKDIR}/git"

# These are not common licenses, set NO_GENERIC_LICENSE for them
# so that the license files will be copied from fetched source
NO_GENERIC_LICENSE[Firmware-qca] = "LICENSE.qca_firmware"

inherit allarch

CLEANBROKEN = "1"

do_compile() {
	:
}

do_install() {
	DESTDIR=${D} make install
}

FILES_${PN} += "/lib/firmware/* /lib/firmware/*/*"

RDEPENDS_${PN} += "crda"
