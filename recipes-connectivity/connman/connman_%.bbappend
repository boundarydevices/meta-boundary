FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

#If connman is used, require silex-uart service to run first, which brings up bluetooth on boot
SRC_URI:append = " file://Require-silex-uart-service-before-connmand-start.patch \
"


