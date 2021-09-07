# Basically core-image-sato-dev + extra packages in IMAGE_INSTALL below

DESCRIPTION = "Image with Sato for development work. It includes everything \
within core-image-sato plus a native toolchain, application development and \
testing libraries, profiling and debug symbols. \
Also includes many other packages for a generic Boundary Devices Evaluation Image"

IMAGE_FEATURES += "splash package-management x11-base x11-sato ssh-server-dropbear hwcodecs dev-pkgs"

LICENSE = "MIT"

inherit core-image features_check

REQUIRED_DISTRO_FEATURES = "x11"
CONFLICT_DISTRO_FEATURES = "wayland"

CORE_IMAGE_BASE_INSTALL += "\
	packagegroup-core-x11-sato-games \
	nodejs \
	packagegroup-fsl-gstreamer1.0-full \
	tslib-tests tslib-calibrate \
	flex \
	gcc \
	git \
	m4 \
	make \
	iperf3 \
	libtool \
	nano \
	python-compiler \
	strace \
	screen \
	minicom \
	openssl \
	cryptodev-module \
	kernel-module-qcacld \
	linux-firmware-bdsdmac \
	silex-uart \
"

# Video input demos only on nitrogen6x/sx/7 platform
CORE_IMAGE_BASE_INSTALL:append:nitrogen6x += "video-input-icon chromium-x11 qt5everywheredemo cinematicexperience"
#CORE_IMAGE_BASE_INSTALL:append:nitrogen6x += "firefox"
CORE_IMAGE_BASE_INSTALL:append:nitrogen6x-lite += "chromium-x11"
CORE_IMAGE_BASE_INSTALL:append:nitrogen6sx += "video-input-icon chromium-x11"
# Chromium not on nitrogen7
CORE_IMAGE_BASE_INSTALL:append:nitrogen7 += "video-input-icon"
