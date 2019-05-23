SRC_URI = "git://github.com/boundarydevices/tslib.git;branch=${SRCBRANCH} \
           file://0001-hack-alert-mxc_ipuv3_fb-increase-memory-for-EXA-driv.patch \
"
SRCBRANCH = "boundary-kergoth"
SRCREV = "${AUTOREV}"

PACKAGECONFIG = "debounce dejitter linear pthres variance input"

COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm)"
