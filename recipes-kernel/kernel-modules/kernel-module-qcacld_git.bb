# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=27608ee1794ad84559bdbc569b811687"

inherit module

SRCREV = "99f0ed2a648facf2c1a3f8d484ed2593611d6b15"
SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;protocol=https;branch=${SRCBRANCH}"
SRCBRANCH = "boundary-CNSS.LEA.NRT_3.1"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "mx6-nxp-bsp|mx7-nxp-bsp|mx8"
