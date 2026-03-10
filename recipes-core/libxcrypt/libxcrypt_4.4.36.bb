require ${COREBASE}/meta/recipes-core/libxcrypt/libxcrypt.inc

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSING;md5=be275bc7f91642efe7709a8ae7a1433b \
                    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/besser82/libxcrypt.git;branch=${SRCBRANCH};protocol=https"

# Commit for v4.4.36
SRCREV = "398943774c5ff38baf1bc5ee088855fd8983bb05"
SRCBRANCH ?= "develop"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"

# Fix multiple definition errors with GCC 10+
CFLAGS:append = " -fcommon"
TARGET_CFLAGS:append = " -fcommon"

# Alternative: patch the source to use 'extern' properly
do_configure:append() {
    # Change the declaration in crypt-common.h from definition to extern
    sed -i 's/^const unsigned char _crypt_ascii64/extern const unsigned char _crypt_ascii64/' \
        ${S}/lib/crypt-common.h || true
}