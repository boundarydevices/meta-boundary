# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;beginline=1;md5=3d45d9c76de5a132519c6d709e2c4ac0"

inherit module

SRCREV = "797abe0b9ed45585493bcf9261b2ea904068f9f5"

SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;branch=${SRCBRANCH} \
"
SRCBRANCH = "boundary-CNSS.LEA.NRT_2.0"

S = "${WORKDIR}/git"

EXTRA_OEMAKE_append = " CONFIG_CLD_HL_SDIO_CORE=y"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"
