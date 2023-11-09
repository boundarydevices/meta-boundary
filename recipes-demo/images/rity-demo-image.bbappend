IMAGE_INSTALL:remove = "u-boot-env"
IMAGE_INSTALL += "\
	${@bb.utils.contains('PREFERRED_PROVIDER_virtual/bootloader', 'u-boot-boundary', 'u-boot-boundary-env', 'u-boot-env', d)} \
	u-boot-script-tungsten-700 \
	memtester \
	ntp \
	phytool \
	hostapd \
"
