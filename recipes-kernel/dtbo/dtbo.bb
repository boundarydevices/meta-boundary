SUMMARY = "Device-Tree Blob Overlays"
inherit devicetree

SRCBRANCH = "mtk-v5.15-pass1"
SRCREV = "fd5fcf1f05fdea1171c07c66abe824003df6320c"
SRC_URI:append = "git://github.com/boundarydevices/linux.git;branch=${SRCBRANCH};protocol=https"

DT_FILES_PATH = "${WORKDIR}"

do_compile[depends] += "virtual/kernel:do_shared_workdir"
KERNEL_INCLUDE:append = " \
	${STAGING_KERNEL_BUILDDIR}/include \
	${STAGING_KERNEL_BUILDDIR}/include/generated \
"

COMPATIBLE_MACHINE = "tungsten-700-smarc"
