FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-start_isp.sh-remove-4k-and-lm-option.patch \
"
