FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://custom-ash.cfg \
"

SRC_URI[custom-ash.cfg.md5sum] = "13d2bc68c91b5c2679ecc652f66832b3"
SRC_URI[custom-ash.cfg.sha256sum] = "7001872f5021b48d010597ce1a614dd35982bdd0045387170408d5946a5c0c7e"
