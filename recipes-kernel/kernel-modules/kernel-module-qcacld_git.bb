# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=5ad90c4733b61c5b2de65aed138c7a25"

inherit module

SRCREV = "fbddadf419c36d487e5a913d89ea72b51f08c0aa"
SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;branch=${SRCBRANCH}"
SRCBRANCH = "boundary-CNSS.LEA.NRT_3.1"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"
