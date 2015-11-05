require core-image-sato.bb

# Basically core-image-sato-dev + extra packages in IMAGE_INSTALL below
DESCRIPTION = "Image with Sato for development work. It includes everything \
within core-image-sato plus a native toolchain, application development and \
testing libraries, profiling and debug symbols. \
Also includes many other packages for a generic Boundary Devices Evaluation Image"

IMAGE_FEATURES += "dev-pkgs"

IMAGE_INSTALL += "\
	chromium \
	firefox \
	nodejs \
	packagegroup-fsl-gstreamer-full \
"
