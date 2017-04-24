SUMMARY = "IIO tools for Linux"
DESCRIPTION = "Tools to monitor and list Industrial I/O (IIO) devices."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit linux-kernel-base kernel-arch kernelsrc

do_configure[depends] += "virtual/kernel:do_shared_workdir"
do_populate_lic[depends] += "virtual/kernel:do_patch"

B = "${WORKDIR}/${BPN}-${PV}"
SPDX_S = "${S}/tools/iio"

EXTRA_OEMAKE = '\
    -C ${S}/tools/iio \
    O=${B} \
    CROSS_COMPILE=${TARGET_PREFIX} \
    ARCH=${ARCH} \
    CC="${CC}" \
    AR="${AR}" \
    LD="${LD}" \
    EXTRA_CFLAGS="-idirafter ${S}/include" \
'

EXTRA_OEMAKE += "\
    'INSTALL_ROOT=${D}' \
    'BINDIR=${bindir}' \
"

do_compile() {
	# Linux kernel build system is expected to do the right thing
	unset CFLAGS
	oe_runmake all
}

do_install() {
	# Linux kernel build system is expected to do the right thing
	unset CFLAGS
	oe_runmake install
}

do_configure_prepend () {
	# Fix for rebuilding
	rm -rf ${B}/
	mkdir -p ${B}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "${bindir}"
