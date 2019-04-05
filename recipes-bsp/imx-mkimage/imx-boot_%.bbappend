SRCBRANCH = "boundary-imx_4.9.123_imx8mm_ga"
SRC_URI = "git://github.com/boundarydevices/imx-mkimage.git;branch=${SRCBRANCH}"
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"

IMXBOOT_TARGETS  = "${@bb.utils.contains('MACHINE', 'nitrogen8mm', "u-boot-lpddr4-iMX8MM-2g.nohdmibin", "u-boot-lpddr4-iMX8M-2g.hdmibin", d)}"
UBOOT_NAME = "u-boot-${MACHINE}.bin"
BOOT_CONFIG_MACHINE = "${BOOT_NAME}-${MACHINE}.bin"

compile_mx8m() {
    bbnote 8MQ/8MM boot binary build
    for ddr_firmware in ${DDR_FIRMWARE_NAME}; do
        bbnote "Copy ddr_firmware: ${ddr_firmware} from ${DEPLOY_DIR_IMAGE} -> ${BOOT_STAGING} "
        cp ${DEPLOY_DIR_IMAGE}/${ddr_firmware}               ${BOOT_STAGING}
    done
    cp ${DEPLOY_DIR_IMAGE}/signed_*_imx8m.bin                ${BOOT_STAGING}
    cp ${DEPLOY_DIR_IMAGE}/u-boot-spl.bin-${MACHINE}	     ${BOOT_STAGING}/u-boot-spl.bin
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/${UBOOT_DTB_NAME}   ${BOOT_STAGING}
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/u-boot-nodtb.bin    ${BOOT_STAGING}
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/mkimage_uboot       ${BOOT_STAGING}
    cp ${DEPLOY_DIR_IMAGE}/${UBOOT_NAME}                     ${BOOT_STAGING}/u-boot.bin
}

do_compile() {
    compile_${SOC_FAMILY}
    # mkimage for i.MX8
    for target in ${IMXBOOT_TARGETS}; do
        bbnote "building ${SOC_TARGET} - ${target}"
        make SOC=${SOC_TARGET} DTBS=${UBOOT_DTB_NAME} ${target}
        if [ -e "${BOOT_STAGING}/${target}" ]; then
            cp ${BOOT_STAGING}/${target} ${S}/${BOOT_CONFIG_MACHINE}-${target}
        fi
    done
}

deploy_mx8m() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${DEPLOY_DIR_IMAGE}/u-boot-spl.bin-${MACHINE} ${DEPLOYDIR}/${BOOT_TOOLS}
    for ddr_firmware in ${DDR_FIRMWARE_NAME}; do
        install -m 0644 ${DEPLOY_DIR_IMAGE}/${ddr_firmware}  ${DEPLOYDIR}/${BOOT_TOOLS}
    done
    install -m 0644 ${DEPLOY_DIR_IMAGE}/signed_hdmi*.bin     ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${BOOT_STAGING}/${TOOLS_NAME}            ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${BOOT_STAGING}/mkimage_fit_atf.sh       ${DEPLOYDIR}/${BOOT_TOOLS}
}
