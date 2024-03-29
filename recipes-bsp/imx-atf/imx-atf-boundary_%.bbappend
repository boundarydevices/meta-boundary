SRCBRANCH = "boundary-lf-6.1.55-2.2.0"
SRCREV = "22b515af81f05137a7deef46b3a472f9e5ae0f4b"

ATF_PLATFORM:mx8ulp-nxp-bsp   = "imx8ulp"

BOOT_TOOLS = "imx-boot-tools"

do_deploy:mx8ulp-nxp-bsp() {
    install -Dm 0644 ${S}/build/${ATF_PLATFORM}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-${ATF_PLATFORM}.bin
    if ${BUILD_OPTEE}; then
        install -m 0644 ${S}/build-optee/${ATF_PLATFORM}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-${ATF_PLATFORM}.bin-optee
    fi
}

COMPATIBLE_MACHINE = "(nitrogen6x-lite|nitrogen6x|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm|nitrogen8mn|nitrogen8mp|nitrogen8ulp)"
