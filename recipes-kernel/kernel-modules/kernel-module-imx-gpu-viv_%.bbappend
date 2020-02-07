SRCBRANCH = "master"
KERNEL_SRC = "git://github.com/boundarydevices/kernel-module-imx-gpu-viv.git;protocol=https"
SRCREV = "60f20868547e7f212be15745540d393402444f2c"
SRC_URI = " \
    ${KERNEL_SRC};branch=${SRCBRANCH} \
"
export KCFLAGS = "-Wno-error=missing-attributes"
