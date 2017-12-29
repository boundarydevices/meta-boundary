SUMMARY = "WiFi firmware files for BD-SDMAC module"
SECTION = "kernel"

LICENSE = "Firmware-qca"

LIC_FILES_CHKSUM = "\
    file://LICENSE.qca_firmware;md5=e8b1e9e8ce377ca5b2c1098e5690f470 \
"

SRCREV = "a74776992fb0580810e122d77dcd14748a55f7f9"

SRC_URI = "git://github.com/boundarydevices/qca-firmware.git;branch=${SRCBRANCH}"
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
