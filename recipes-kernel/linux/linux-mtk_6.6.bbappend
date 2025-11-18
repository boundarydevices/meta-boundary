
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LINUX_VERSION = "6.6.92-boundary"
SRCBRANCH = "ezurio-mtk-v6.6-pass2"
SRCREV = "bc4f79322d101d2c54eaae4ce1a90c794230f620"
SRC_URI = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https"

SRC_URI:append := " \
	file://tungsten.cfg \
	file://reduce_kernel.cfg \
"

SRC_URI:remove = " \
	file://0001-GENIO-drivers-lib-Strip-path-components.patch \
"
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
