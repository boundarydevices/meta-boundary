# Copyright (C) 2016 Boundary Devices
SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=5ad90c4733b61c5b2de65aed138c7a25"

inherit module

SRCREV = "e1a3e5f50d16a21a807b3d3fab77bb7dc6a57da2"

SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;branch=${SRCBRANCH} \
"
SRCBRANCH = "boundary-CNSS.LEA.NRT_2.0"

S = "${WORKDIR}/git"

EXTRA_OEMAKE_append = " CONFIG_CLD_HL_SDIO_CORE=y"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"
