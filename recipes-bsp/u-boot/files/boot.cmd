setenv bootargs ''

if itest.s x${display_dtbo} == x ; then
	setenv display_dtbo display-hdmi.dtbo;
fi

if itest.s "x" == "x${distro_bootpart}" ; then
	part number ${devtype} ${devnum} rootfs distro_bootpart
fi

setenv bootargs ${bootargs} console=ttyS0,115200;

if itest.s "x" != "x${loglevel}" ; then
	setenv bootargs ${bootargs} loglevel=${loglevel}
else
	setenv bootargs ${bootargs} quiet
fi

if itest.s "x" != "x${cmd_custom}" ; then
	run cmd_custom
fi

setexpr bpart fmt %d ${distro_bootpart}
if test "usb" = "${devtype}" ; then
	setenv bootargs "${bootargs} root=/dev/sda${bpart}";
else
	setenv bootargs "${bootargs} root=/dev/mmcblk${devnum}p${bpart}";
fi

read ${devtype} ${devnum}#kernel ${loadaddr} 0 0xffff;
bootm ${loadaddr}#conf-mediatek_mt8390-tungsten_smarc.dtb#conf-apusys.dtbo#conf-${display_dtbo}#conf-gpu-mali.dtbo#conf-video.dtbo;
