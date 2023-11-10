setenv bootargs ''

if itest.s x${display_dtbo} == x ; then
	setenv display_dtbo display-hdmi.dtbo;
fi

if itest.s "x" == "x${distro_bootpart}" ; then
	part number ${devtype} ${devnum} rootfs distro_bootpart
fi

setexpr b0 ${distro_bootpart} % 0x0a;
setexpr b1 ${distro_bootpart} / 0x0a;
setexpr bpart ${b1} * 0x10
setexpr bpart ${bpart} + ${b0};

if test "usb" = "${devtype}" ; then
	setenv bootargs "${bootargs} root=/dev/sda${bpart}";
else
	setenv bootargs "${bootargs} root=/dev/mmcblk${devnum}p${bpart}";
fi

setenv bootargs ${bootargs} console=ttyS0,115200;

part number ${devtype} ${devnum} kernel kernelpart

read ${devtype} ${devnum}:${kernelpart} ${loadaddr} 0 0xffff;
bootm ${loadaddr}#conf-mediatek_mt8390-tungsten_smarc.dtb#conf-apusys.dtbo#conf-${display_dtbo}#conf-gpu-mali.dtbo#conf-video.dtbo;
