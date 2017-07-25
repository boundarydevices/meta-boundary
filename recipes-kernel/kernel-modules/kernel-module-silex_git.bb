# Copyright (C) 2016 Boundary Devices
SUMMARY = "Silex QCA9377 WiFi kernel module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;beginline=1;endline=20;md5=c191a07d6df8a17ee5b865137f729304"

inherit module

SRCREV = "ccc4f3062179eff2a49424fcc3776216da1f48fd"

SRC_URI = "git://github.com/boundarydevices/qcacld-2.0.git;branch=${SRCBRANCH} \
"
SRCBRANCH = "boundary-LNX.LEH.4.2.2.2"

S = "${WORKDIR}/git"

do_compile(){
	KERNELDIRPATH=${WORKDIR}/../../linux-boundary/
	KERNELVERSION=`ls ${KERNELDIRPATH}`
	# Fairly certain build directory always exists and doesn't get cached in
	KERNEL_SRC=${KERNELDIRPATH}/${KERNELVERSION}/build CONFIG_CLD_HL_SDIO_CORE=y make
}

COMPATIBLE_MACHINE = "mx6|mx7"
