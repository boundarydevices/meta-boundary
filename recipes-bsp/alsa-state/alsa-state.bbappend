FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:prepend = " \
	file://asound.conf \
	file://asound.state \
"
