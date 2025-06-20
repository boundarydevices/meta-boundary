FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
        file://1001-cmake-deps.txt-fix-eigen-hash.patch \
        "
