SUMMARY = "Device-Tree Blob Overlays"
inherit devicetree

SRCBRANCH = "boundary-mtk-v5.15-dev"
SRCREV = "7bfc048948e7f8646123893a1984f775d1eff0cf"
SRC_URI:append = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https"

S = "${WORKDIR}/git"

DT_FILES_PATH = "${S}/arch/arm64/boot/dts/mediatek/mt83x0-tungsten-smarc"

do_unpack_dtbo_tungsten510() {
    cp ${S}/arch/arm64/boot/dts/mediatek/mt8370/* ${S}/arch/arm64/boot/dts/mediatek/mt83x0-tungsten-smarc
}

do_unpack_dtbo_tungsten700() {
    cp ${S}/arch/arm64/boot/dts/mediatek/mt8390/* ${S}/arch/arm64/boot/dts/mediatek/mt83x0-tungsten-smarc
}

python do_unpack:append:tungsten-510-smarc() {
    bb.build.exec_func('do_unpack_dtbo_tungsten510', d)
}

python do_unpack:append:tungsten-700-smarc() {
    bb.build.exec_func('do_unpack_dtbo_tungsten700', d)
}

do_compile[depends] += "virtual/kernel:do_shared_workdir"
KERNEL_INCLUDE:append = " \
	${STAGING_KERNEL_BUILDDIR}/include \
	${STAGING_KERNEL_BUILDDIR}/include/generated \
"

COMPATIBLE_MACHINE = "(tungsten-510-smarc|tungsten-700-smarc)"
