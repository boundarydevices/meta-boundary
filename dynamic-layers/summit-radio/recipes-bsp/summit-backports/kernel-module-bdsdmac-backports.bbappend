BACKPORTS_CONFIG = "bdimx8"

addtask export_sources after do_patch before do_configure
do_export_sources[depends] += "virtual/kernel:do_shared_workdir"

do_export_sources() {
    # some kernel versions have issues with stdarg.h and compatibility with
    # the sysroot and libc-headers/uapi. If we include the file directly from
    # the kernel source (STAGING_KERNEL_DIR) we get conflicting types on many
    # structures, due to kernel .h files being found before libc .h files.
    # if we grab just this one file from the source, and put it into our
    # file structure, everything holds together
    install ${STAGING_KERNEL_DIR}/include/linux/stdarg.h  ${S}/drivers/net/wireless/summit/qcacld/CORE/VOSS/inc
}

# add nx611 module parameters
module_conf_btnxpuart = "softdep btnxpuart pre: moal"
module_conf_moal = "options moal mod_para=nxp/wifi_prod_serdev_params.conf"
KERNEL_MODULE_PROBECONF += "btnxpuart moal"
