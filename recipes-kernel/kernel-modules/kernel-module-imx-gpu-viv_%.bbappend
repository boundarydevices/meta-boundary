SRCBRANCH = "master"
KERNEL_SRC = "git://github.com/boundarydevices/kernel-module-imx-gpu-viv.git;protocol=https"
SRCREV = "1bba2683ed4c872472a00ee58562dc8b430abc75"
SRC_URI = " \
    ${KERNEL_SRC};branch=${SRCBRANCH} \
"
export KCFLAGS = "-Wno-error=missing-attributes"
