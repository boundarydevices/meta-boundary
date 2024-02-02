FILESEXTRAPATHS:prepend:nitrogen8ulp := "${THISDIR}/nitrogen8ulp:"

do_deploy:append:nitrogen8ulp () {
   # Install the demo binaries
   install -m 0644 ${WORKDIR}/*.${DEPLOY_FILE_EXT} ${DEPLOYDIR}/
}
