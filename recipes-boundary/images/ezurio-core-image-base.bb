# This image extends core-image with additional
# Porpoise/Ezurio Devices packages

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL_WIFI_BT ?= "${IMAGE_INSTALL_WIFI_BT_PKGS}"
IMAGE_INSTALL_WIFI_BT_PKGS = " \
    nx61x-firmware \
    kernel-module-bdsdmac-backports \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    atinout \
    can-utils \
    curl \
    e2fsprogs \
    fw-env-rules \
    i2c-tools \
    iperf3 \
    iproute2 \
    libgpiod \
    libgpiod-tools \
    memtester \
    minicom \
    mmc-utils \
    modemmanager \
    networkmanager \
    networkmanager-nmcli \
    openssh \
    packagegroup-tools-bluetooth \
    pciutils \
    screen \
    spitools \
    strace \
    u-boot-boundary-env \
    u-boot-fw-utils \
    udev-rules-imx \
    v4l-utils \
    wireless-regdb-static \
    ${IMAGE_INSTALL_WIFI_BT} \
"
