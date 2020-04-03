SRC_URI = "git://github.com/boundarydevices/tslib.git;branch=${SRCBRANCH} \
"
SRCBRANCH = "boundary-kergoth"
SRCREV = "16cece58dcc7ac3029e40c2c16e8adc837fd1171"

PACKAGECONFIG = "debounce dejitter linear pthres variance input"

COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm)"
