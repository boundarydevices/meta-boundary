# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=de52d2c36fece51dcd41994f8578ff11"

inherit module

SRCREV = "00ba3c6598053ea74fefe2f265828064c39152b0"
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
