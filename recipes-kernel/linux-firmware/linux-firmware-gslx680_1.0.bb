SUMMARY = "Firmware files for GSLx680 touch controllers"
SECTION = "kernel"

LICENSE = "\
    GPLv2+ \
"

LIC_FILES_CHKSUM = "\
    file://${WORKDIR}/LICENSE.GPLv2+.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

SRC_URI_append = "\
    http://linode.boundarydevices.com/gsl1680.fw;name=gsl1680 \
    http://linode.boundarydevices.com/LICENSE.GPLv2+.txt;name=license \
"

SRC_URI[gsl1680.sha256sum] = "d0e85f5b601e58ef04dd016f99de89aebdc5e16c7b0173f45196f9593d43e854"
SRC_URI[license.sha256sum] = "8177f97513213526df2cf6184d8ff986c675afb514d4e68a404010521b880643"

inherit allarch update-alternatives

CLEANBROKEN = "1"

do_install() {
    mkdir -p ${D}/lib/firmware/
    install -m 0644 ${WORKDIR}/gsl1680.fw ${D}/lib/firmware/
}

FILES_${PN} += "/lib/firmware/*"
