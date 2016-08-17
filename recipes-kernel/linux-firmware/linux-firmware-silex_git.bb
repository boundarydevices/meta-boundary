SUMMARY = "Firmware files for Silex wifi/bt module"
SECTION = "kernel"

LICENSE = "\
    Firmware-QCA \
"

LIC_FILES_CHKSUM = "\
    file://LICENSE.TXT;md5=3d1167bd6ce1e9763e791a3d5bab379f \
"

# These are not common licenses, set NO_GENERIC_LICENSE for them
# so that the license files will be copied from fetched source
NO_GENERIC_LICENSE[Firmware-QCA] = "LICENCE.TXT"

SRCREV = "889689ade3266a14557ccfd1b8c4ef47d2379ede"

SRC_URI = "git://git@linode.boundarydevices.com/qca-firmware.git;protocol=ssh"

S = "${WORKDIR}/git"

inherit allarch update-alternatives

CLEANBROKEN = "1"

do_compile() {
	:
}

do_install() {
	DESTDIR=${D} make install
}

FILES_${PN} += "/lib/firmware/* /lib/firmware/*/*"
