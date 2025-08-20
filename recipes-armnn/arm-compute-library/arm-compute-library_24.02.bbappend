
SRC_URI = "git://github.com/ARM-software/ComputeLibrary.git;protocol=https;nobranch=1;name=arm-compute-library \
           file://0001-enable-yocto-build.patch \
           file://0001-Remove-unknown-variables-treated-as-error.patch \
           file://0001-Prefer-to-use-libmali-as-the-provider-of-OpenCL.patch \
	   file://0001-remove-clUpdateMutableCommandsKHR-reference.patch \
           "
