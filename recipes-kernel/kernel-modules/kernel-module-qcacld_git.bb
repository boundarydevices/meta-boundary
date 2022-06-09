# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=068b1bd996d8acea0daa18111e303f5a"

inherit module

SRCREV = "ebd547904655a3d8338c0c64571bf3b7e594ef6b"
SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;protocol=https;branch=${SRCBRANCH}"
SRCBRANCH = "boundary-CNSS.LEA.NRT_3.1"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "mx6-nxp-bsp|mx7-nxp-bsp|mx8"
