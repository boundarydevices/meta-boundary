# Copyright (C) 2020 Boundary Devices
SUMMARY = "QCACLD driver for QCA6174-based SX-PCEAC2 module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;md5=b322e2f438f07bf86cece8ffd5c0a778"

inherit module

SRCREV = "913fda7537ab240ca5b1b143a81e9b36e50ad007"

SRC_URI = "git://github.com/boundarydevices/qca6174a-lnx4_14-driver-source.git;branch=${SRCBRANCH}"

SRCBRANCH = "master"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    CONFIG_NON_QC_PLATFORM=y  \
    CONFIG_ROME_IF=pci \
    CONFIG_WLAN_FEATURE_11W=y \
    CONFIG_WLAN_FEATURE_FILS=y \
    CONFIG_WLAN_WAPI_MODE_11AC_DISABLE=y \
    MODNAME=wlan \
"

EXTRA_OEMAKE += " CONFIG_CFG80211_INTERNAL_REGDB=y CONFIG_PMF_SUPPORT=y CONFIG_LINUX_QCMBR=y"

EXTRA_OEMAKE += " CONFIG_HDD_WLAN_WAIT_TIME=5000"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"

