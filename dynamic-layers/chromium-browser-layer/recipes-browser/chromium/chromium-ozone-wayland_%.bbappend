# Enable system EGL linkages ONLY for the i.MX8MQ target platform
PACKAGECONFIG:append:mx8mq-nxp-bsp = " use-egl"

# Safely remove Vulkan (which conflicts with the Vivante engine) only for the i.MX8MQ
PACKAGECONFIG:remove:mx8mq-nxp-bsp = "vulkan"

# Override the proprietary codec flags specifically for the mx8mq build loop
GN_ARGS_ENABLE_PROPRIETARY_CODECS:mx8mq-nxp-bsp = "proprietary_codecs=false"
GN_ARGS_FFMPEG_BRANDING:mx8mq-nxp-bsp = 'ffmpeg_branding="Chromium"'
