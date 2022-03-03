update_file() {
    if ! grep -q "$1" $3; then
        bbfatal $1 not found in $3
    fi
    sed -i -e "s,$1,$2," $3
}

do_install:append() {
    # FIXME: weston should be run as weston, not as root
    update_file "User=weston" "User=root" ${D}${systemd_system_unitdir}/weston.service
    update_file "Group=weston" "Group=root" ${D}${systemd_system_unitdir}/weston.service
}
