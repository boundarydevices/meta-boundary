DESCRIPTION = "Add packages for AI/ML build"

inherit packagegroup

ML_PKGS = " \
    armnn \
    pyarmnn \
    tensorflow-lite \
    onnxruntime \
    pytorch \
    torchvision \
"
RDEPENDS_${PN} = " \
    ${ML_PKGS} \
"
