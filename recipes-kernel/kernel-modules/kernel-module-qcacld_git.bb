# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=4fc68daa3c9044cebf92216503d21dba"

inherit module

SRCREV = "5e16c67c7645ac3a6c40fb696ff15f8d36461e7c"

SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;branch=${SRCBRANCH} \
"
SRCBRANCH = "boundary-CNSS.LEA.NRT_2.0"

S = "${WORKDIR}/git"

EXTRA_OEMAKE_append = " CONFIG_CLD_HL_SDIO_CORE=y"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"
