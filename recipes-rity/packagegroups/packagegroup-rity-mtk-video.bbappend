# Temporary to get around a compile error
# in mtk-vcodec-driver-mt8391 which we do not need
# Boundary only needs these modules

RDEPENDS:${PN} = " \
	mtk-vcu-driver-mt8395 \
	mtk-vcodec-driver-mt8395 \
	mtk-vpud \
"
