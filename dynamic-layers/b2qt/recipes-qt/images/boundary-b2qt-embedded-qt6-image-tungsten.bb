require recipes-qt/images/b2qt-embedded-qt6-image.bb
require recipes-demo/images/rity-demo-image.bb

IMAGE_INSTALL:remove = "u-boot-env"
IMAGE_INSTALL += "\
	${@bb.utils.contains('PREFERRED_PROVIDER_virtual/bootloader', 'u-boot-boundary', 'u-boot-boundary-env', 'u-boot-env', d)} \
	u-boot-script-tungsten-700 \
	memtester \
	ntp \
	phytool \
	hostapd \
	tslib-tests tslib-calibrate \
"

# Boot2Qt BSP uses connman, so need to remove packagegroups that install networkmanager
IMAGE_INSTALL:remove = "packagegroup-rity-net-extended packagegroup-rity-tools packagegroup-rity-tools-extended"
