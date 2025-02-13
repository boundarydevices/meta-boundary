FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://0001-Import-imx219-support-from-camera-sw-pack.patch \
	file://0002-imx-add-dual-imx219-support.patch \
	file://0003-imx-start_isp.sh-always-use-1080p-for-Basler.patch \
	file://0004-imx-run.sh-never-load-the-modules-manually.patch \
"

FILES:${PN}-dev += " ${libdir}/libimx219.so"
