# This image extends boundary-image-multimedia-full with chromium added

require recipes-boundary/images/boundary-image-multimedia-full.bb

CORE_IMAGE_EXTRA_INSTALL += "chromium-ozone-wayland "
