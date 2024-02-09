include conf/distro/include/imx.inc

DEPLOY_CONF_NAME:nitrogen8m = "nitrogen8m"
DEPLOY_CONF_NAME:nitrogen8mm = "nitrogen8mm"
DEPLOY_CONF_NAME:nitrogen8mp = "nitrogen8mp"
DEPLOY_CONF_TYPE = "Boot2Qt 6.6.1"

DRI_DEVICE:nitrogen8m = "card0"
DRI_DEVICE:nitrogen8mm = "card0"
DRI_DEVICE:nitrogen8mp = "card1"

IMAGE_BUILDINFO_VARS:append = " DEPLOY_CONF_NAME DEPLOY_CONF_TYPE"
