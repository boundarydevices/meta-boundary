SUMMARY = "Device-Tree Blob Overlays"
inherit devicetree

SRCBRANCH = "mtk-v5.15-pass1"
SRCREV = "fd5fcf1f05fdea1171c07c66abe824003df6320c"
SRC_URI:append = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https"

S = "${WORKDIR}/git"

DT_FILES_PATH = "${S}/arch/arm64/boot/dts/mediatek/dtbo"

do_compile[depends] += "virtual/kernel:do_shared_workdir"
KERNEL_INCLUDE:append = " \
	${STAGING_KERNEL_BUILDDIR}/include \
	${STAGING_KERNEL_BUILDDIR}/include/generated \
"

COMPATIBLE_MACHINE = "(tungsten-510-smarc|tungsten-700-smarc)"
