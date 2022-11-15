# Temporarily reset variable coming from meta-boot2qt layer. It causes build issue on mx8mm machines:
# ERROR: Required build target 'b2qt-embedded-qt6-image' has no buildable providers.
# Missing or unbuildable dependency chain was: ['b2qt-embedded-qt6-image', 'packagegroup-b2qt-embedded-addons', 'boot2qt-appcontroller', 'qtbase', 'vulkan-loader', 'libvulkan-imx']
# as vulkan no longer supported on mx8mm:
# https://github.com/Freescale/meta-freescale/commit/140ad9c0826a499a9cae2583bf72f0e2e74e3dbf
RRECOMMENDS:${PN}:use-nxp-bsp = ""
