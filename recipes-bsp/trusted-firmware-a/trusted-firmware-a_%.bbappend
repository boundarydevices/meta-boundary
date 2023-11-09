FILESEXTRAPATHS:append := "${THISDIR}/files:"
SRCREV_tfa = "11a3e271252e3f7583046615c1e8b3b33533d636"
SRC_URI:append:mt8390 = "file://0002-BL2-mediatek-Change-UART_BAUDRATE-to-115200.patch \
		file://0003-trusted-firmware-a-Use-LOG_LEVEL_ERROR-for-Release-b.patch \
"

