SUMMARY = "WiFi and BT firmware files for SX-PCEAC2 module"
SECTION = "kernel"
LICENSE = "boundary"

LIC_FILES_CHKSUM = "\
    file://bdwlan30.bin;md5=28be80feccd35ab4881d83680ba468a5 \
"

SRCREV = "ffca74bb3adf283cc78fb5ce5cde6b890b6e5abc"

SRC_URI = "git://github.com/boundarydevices/qca6174-firmware.git;branch=${SRCBRANCH}"

SRCBRANCH = "master"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
	install -d ${D}${base_libdir}/firmware
	cp -r ${S}/* ${D}${base_libdir}/firmware/
}

FILES_${PN} += "/lib/firmware/* /lib/firmware/*/*"

RDEPENDS_${PN} += "crda"
