SRC_URI = "git://github.com/boundarydevices/tslib.git;branch=${SRCBRANCH} \
"
SRCBRANCH = "boundary-kergoth"
SRCREV = "${AUTOREV}"

PACKAGECONFIG = "debounce dejitter linear pthres variance input"

COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm)"
