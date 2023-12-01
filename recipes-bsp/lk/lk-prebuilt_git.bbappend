FILESEXTRAPATHS:append := "${THISDIR}/files:"

SRC_URI:append = " \
	file://lk.bin \
"

BUILD = "${WORKDIR}"
