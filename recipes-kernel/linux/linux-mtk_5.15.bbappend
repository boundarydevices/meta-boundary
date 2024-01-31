LINUX_VERSION ?= "5.15.x-boundary"
SRCBRANCH = "boundary-mtk-v5.15-dev"
SRCREV = "7bfc048948e7f8646123893a1984f775d1eff0cf"
SRC_URI = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https"

KBUILD_DEFCONFIG = "boundary_defconfig"

# Needed for kernel-fitimage-mtk class so dtbos are installed in fitimage
python __anonymous () {
    d.setVar('EXTERNAL_KERNEL_DEVICETREE', "${D}/boot/devicetree")
}

# Install dtbos
do_install:append() {
    install -d ${D}/boot/devicetree/
    install -Dm 0644 ${B}/arch/arm64/boot/dts/mediatek/mt83x0-tungsten-smarc/*.dtbo ${D}/boot/devicetree/
}

do_install:append:tungsten-510-smarc() {
    install -Dm 0644 ${B}/arch/arm64/boot/dts/mediatek/mt8370/*.dtbo ${D}/boot/devicetree/
}

do_install:append:tungsten-700-smarc() {
    install -Dm 0644 ${B}/arch/arm64/boot/dts/mediatek/mt8390/*.dtbo ${D}/boot/devicetree/
}

