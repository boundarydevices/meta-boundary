FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"

SRC_URI:append:mx93-nxp-bsp = " \
	file://mx93a1-ahab-container.img \
"

do_install:prepend:mx93-nxp-bsp () {
    cp ${WORKDIR}/mx93a1-ahab-container.img ${S}/
}
