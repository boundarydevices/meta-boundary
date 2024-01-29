LINUX_VERSION ?= "5.15.x-boundary"
SRCBRANCH = "boundary-mtk-v5.15-dev"
SRCREV = "7bfc048948e7f8646123893a1984f775d1eff0cf"
SRC_URI = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https"

KBUILD_DEFCONFIG = "boundary_defconfig"
