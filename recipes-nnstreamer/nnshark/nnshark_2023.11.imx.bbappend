# Update to the NXP commit that fixed the broken submodule URL
SRCREV:forcevariable = "4ed66906b889e66a6458a1d2692790f64bf1c556"

# Ensure gitsm is used so it fetches the now-fixed submodules automatically
NNSHARK_SRC = "gitsm://github.com/nxp-imx/nnshark.git;protocol=https"
SRC_URI = "${NNSHARK_SRC};branch=${SRCBRANCH}"

# Clear the common-specific overrides as they are no longer needed
SRCREV_common = ""