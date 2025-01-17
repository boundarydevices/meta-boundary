DESCRIPTION = "Atinout is a program that will execute AT commands in sequence \
and capture the response from the modem."
DEPENDS = ""
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/gplv3.txt;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://git.code.sf.net/p/atinout/code.git;branch=${SRCBRANCH};protocol=https \
           file://0001-Makefile-update-CFLAGS.patch \
"
SRCBRANCH = "master"
SRCREV = "4976a6cb5237373b7e23cd02d7cd5517f306e3f6"

S = "${WORKDIR}/git"

export STAGING_INCDIR_AT="${STAGING_INCDIR}"
export STAGING_DIR_TARGET_AT = "${STAGING_DIR_TARGET}"

INSANE_SKIP:${PN} += "ldflags"

EXTRA_OEMAKE += " \
    CC="${TARGET_PREFIX}gcc" \
"

inherit autotools

PARALLEL_MAKE = ""

do_compile () {
    oe_runmake -C ${S} atinout
}

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${S}/atinout ${D}${sbindir}
}
