
# Hopefully only a temporary fix
SRC_URI:remove = "git://github.com/ARM-software/ComputeLibrary.git;protocol=https;branch=main;name=arm-compute-library"
SRC_URI:append = "git://github.com/ARM-software/ComputeLibrary.git;protocol=https;branch=archived-releases;name=arm-compute-library"
