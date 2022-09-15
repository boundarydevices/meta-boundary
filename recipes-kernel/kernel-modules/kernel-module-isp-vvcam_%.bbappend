FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
    file://0001-vvcam-video-add-of-match-table.patch \
    file://0001-vvcam-video-remove-pdev-device.patch \
"
