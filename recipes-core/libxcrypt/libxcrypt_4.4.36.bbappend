# Fix multiple definition errors with GCC 10+
CFLAGS:append = " -fcommon"
TARGET_CFLAGS:append = " -fcommon"

# Alternative: patch the source to use 'extern' properly
do_configure:append() {
    # Change the declaration in crypt-common.h from definition to extern
    sed -i 's/^const unsigned char _crypt_ascii64/extern const unsigned char _crypt_ascii64/' \
        ${S}/lib/crypt-common.h || true
}
