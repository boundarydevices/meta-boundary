# Override to the version that includes openat2 support
SRCREV = "6c0d8c6b81ca7c2ef2b5a9a996605e1a51814442"
PV = "1.9.4"

# Remove old patches that are incompatible with the new version.
SRC_URI:remove = "file://0001-configure-Prune-PIE-flags.patch \
                  file://older-glibc-symbols.patch \
                  file://0001-pseudo-remove-static-link.patch \
                  file://0001-pseudo-realpath.c-Remove-TOSTRING-recursion.patch \
                  file://0001-guts-readdir-Use-guts_strlen.patch \
                  file://0001-Ensure-all-closefrom-parameters-are-declared-typed.patch"
