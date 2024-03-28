LINUX_VERSION ?= "5.15.x-boundary"
SRCBRANCH = "boundary-mtk-v5.15-dev"
SRCREV = "6b74d5a3c7801d4a3a5d77b4ef7d4b4c68a10425"
SRC_URI = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https"

KBUILD_DEFCONFIG = "boundary_defconfig"

# Needed for kernel-fitimage-mtk class so dtbos are installed in fitimage
python __anonymous () {
    d.setVar('EXTERNAL_KERNEL_DEVICETREE', "${D}/boot/devicetree/")
}

# Install dtbos
do_install_dtos() {
    install -d ${D}/boot/devicetree/
    install -Dm 0644 ${B}/arch/arm64/boot/dts/mediatek/mt83x0-tungsten-smarc/*.dtbo ${D}/boot/devicetree/
}

do_install_dtos:append:tungsten-510-smarc() {
    install -d ${D}/boot/devicetree/
    install -Dm 0644 ${B}/arch/arm64/boot/dts/mediatek/mt8370/*.dtbo ${D}/boot/devicetree/
}

do_install_dtos:append:tungsten-700-smarc() {
    install -d ${D}/boot/devicetree/
    install -Dm 0644 ${B}/arch/arm64/boot/dts/mediatek/mt8390/*.dtbo ${D}/boot/devicetree/
}

addtask do_install_dtos after do_compile before do_assemble_fitimage
