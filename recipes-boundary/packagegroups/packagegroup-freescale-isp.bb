DESCRIPTION = "Add packages for ISP build"

inherit packagegroup

ISP_PKGS = " \
    isp-imx \
    basler-camera \
    basler-camera-dev \
    kernel-module-isp-vvcam \
"
RDEPENDS_${PN} = " \
    ${ISP_PKGS} \
"
