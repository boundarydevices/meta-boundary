FILESEXTRAPATHS:append:nitrogen8ulp := "${THISDIR}/nitrogen8ulp:"

SRC_URI:append:nitrogen8ulp = " file://power_mode_switch_2.15.0.bin"

do_deploy:append:nitrogen8ulp () {
   # Install the demo binaries
   install -m 0644 ${WORKDIR}/*.${DEPLOY_FILE_EXT} ${DEPLOYDIR}/
}
