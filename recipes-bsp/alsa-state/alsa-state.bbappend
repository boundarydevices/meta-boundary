# Append path for boundarydevices layer to include alsa-state
# Includes default 75% volume setting
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH_mx7 = "${MACHINE_ARCH}"
PACKAGE_ARCH_mx6 = "${MACHINE_ARCH}"
