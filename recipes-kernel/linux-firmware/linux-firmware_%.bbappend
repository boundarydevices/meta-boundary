# Support additional firmware for TiWi-BLE module
# TIInit_7.6.15.bts is required for bluetooth support but this particular
# version is not available in the linux-firmware repository.
#
SRC_URI_append = "\
    https://git.ti.com/ti-bt/service-packs/blobs/raw/54f5c151dacc608b19ab2ce4c30e27a3983048b2/initscripts/TIInit_7.6.15.bts;name=TIInit_7.6.15 \
"
SRC_URI[TIInit_7.6.15.md5sum] = "3f84f0d782376363d0028fc4b2402ccb"
SRC_URI[TIInit_7.6.15.sha256sum] = "e78156ad81446fdeb46da661290f763f3fe97d111526b2d19cd764a634268888"

do_install_append() {
    cp ${WORKDIR}/TIInit_7.6.15.bts ${D}/lib/firmware/ti-connectivity/
}

PACKAGE_ARCH_mx7 = "${MACHINE_ARCH}"
PACKAGE_ARCH_mx6 = "${MACHINE_ARCH}"
