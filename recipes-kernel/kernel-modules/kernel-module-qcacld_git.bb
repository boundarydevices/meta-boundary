# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=756587ed3b822051e04ecdb5fffb243e"

inherit module

SRCREV = "2cd31b656bf98566e1e90272d2bda594fe7f64cb"
SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;protocol=https;branch=${SRCBRANCH}"
SRCBRANCH = "boundary-CNSS.LEA.NRT_3.1"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "mx6-nxp-bsp|mx7-nxp-bsp|mx8"

addtask export_sources after do_patch before do_configure
do_export_sources[depends] += "virtual/kernel:do_shared_workdir"

do_export_sources() {
    # some kernel versions have issues with stdarg.h and compatibility with
    # the sysroot and libc-headers/uapi. If we include the file directly from
    # the kernel source (STAGING_KERNEL_DIR) we get conflicting types on many
    # structures, due to kernel .h files being found before libc .h files.
    # if we grab just this one file from the source, and put it into our
    # file structure, everything holds together
    install ${STAGING_KERNEL_DIR}/include/linux/stdarg.h  ${S}/CORE/VOSS/inc
}
