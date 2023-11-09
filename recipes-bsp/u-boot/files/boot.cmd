setenv bootargs ''

if itest.s x${display_dtbo} == x ; then
	setenv display_dtbo display-dsi.dtbo;
fi

if itest.s "x" == "x${bpart}" ; then
	bpart=10
fi

if test "usb" = "${devtype}" ; then
	setenv bootargs "${bootargs} root=/dev/sda${bpart}";
else
	setenv bootargs "${bootargs} root=/dev/mmcblk${devnum}p${bpart}";
fi

setenv bootargs ${bootargs} console=ttyS0,115200;

read mmc 0:9 $loadaddr 0 0xffff;
bootm $loadaddr#conf-mediatek_mt8390-tungsten_smarc.dtb#conf-apusys.dtbo#conf-${display_dtbo}#conf-gpu-mali.dtbo#conf-video.dtbo;
