LINUX_VERSION ?= "6.6.x-boundary"
SRCBRANCH = "ezurio-mtk-v6.6-pass1"
SRCREV = "f69c9f57e11c914c0b0a01b748c00f7f59348f0d"
SRC_URI = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https"

# Add the Linux kernel config fragment as a Yocto config fragment
SRC_URI:append := "https://raw.githubusercontent.com/boundarydevices/linux/${SRCREV}/arch/arm64/configs/tungsten.config;downloadfilename=tungsten.cfg"
SRC_URI[sha256sum] = "7166cfdce8c2655fbadb3fe86c28e087702f7696658afd3d91687eb2ec69bf14"

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
