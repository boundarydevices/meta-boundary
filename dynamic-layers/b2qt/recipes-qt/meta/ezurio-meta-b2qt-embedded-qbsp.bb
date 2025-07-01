# This image extends meta-b2qt-embedded-qbsp with additional
# Ezurio packages

require recipes-qt/meta/meta-b2qt-embedded-qbsp.bb

QBSP_SDK = "${DISTRO}-${SDKMACHINE}-${QBSP_SDK_TASK}-${MACHINE}"
QBSP_IMAGE_TASK = "ezurio-b2qt-embedded-qt6-image"
