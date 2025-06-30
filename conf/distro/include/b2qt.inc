include conf/distro/include/imx.inc

DEPLOY_CONF_NAME:nitrogen8m = "Ezurio Nitrogen8M"
DEPLOY_CONF_NAME:nitrogen8mm = "Ezurio Nitrogen8M Mini"
DEPLOY_CONF_NAME:nitrogen8mp = "Ezurio Nitrogen8M Plus"
DEPLOY_CONF_NAME:nitrogen8ulp = "Ezurio Nitrogen8ULP"
DEPLOY_CONF_NAME:nitrogen93 = "Ezurio Nitrogen93"
DEPLOY_CONF_NAME:nitrogen95 = "Ezurio Nitrogen95"
DEPLOY_CONF_TYPE = "Boot2Qt 6.8.1"

DRI_DEVICE:nitrogen8m = "card0"
DRI_DEVICE:nitrogen8mm = "card0"
DRI_DEVICE:nitrogen8mp = "card1"

IMAGE_BUILDINFO_VARS:append = " DEPLOY_CONF_NAME DEPLOY_CONF_TYPE"
