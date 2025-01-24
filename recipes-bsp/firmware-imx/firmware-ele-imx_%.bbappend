FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"

SRC_URI:append:mx93-nxp-bsp = " \
	file://mx93a1-ahab-container.img \
"

SRC_URI[md5sum] = "777d36d1bc39522d975165686935fc33"
SRC_URI[sha256sum] = "5d50d5c7a9d1bcc225ca8dc62a582074d88e3adb6c5eea2d1614aa18c61d6ff9"

do_install:prepend:mx93-nxp-bsp () {
    cp ${WORKDIR}/mx93a1-ahab-container.img ${S}/
}
