FILESEXTRAPATHS:prepend:tungsten-700-smarc := "${THISDIR}/tungsten-700-smarc:"
FILESEXTRAPATHS:prepend:tungsten-510-smarc := "${THISDIR}/tungsten-510-smarc:"

SRC_URI:prepend = " \
	file://asound.conf \
	file://asound.state \
"
