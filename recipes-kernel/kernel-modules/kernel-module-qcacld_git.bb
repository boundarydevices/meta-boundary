# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=27608ee1794ad84559bdbc569b811687"

inherit module

SRCREV = "75040472fd9f5883add2b68277ac3b4dce191167"
SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;branch=${SRCBRANCH}"
SRCBRANCH = "boundary-CNSS.LEA.NRT_3.1"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"
