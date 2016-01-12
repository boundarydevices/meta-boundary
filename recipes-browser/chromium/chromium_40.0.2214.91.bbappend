# GCC5.2 causes compilation errors on this old version of chromium
# meta-browser is patched to work-around the compile errors
# However it additionally needs this flag to boot without a SegFault
CHROMIUM_EXTRA_ARGS += "--ignore-gpu-blacklist"

# Chromium code has a hard-coded path to the video playing library
# It looks within the binary path and NOT the library path.
# Add our own package as to avoid conflicts.
PACKAGES =+ "${PN}-codecs-ffmpeg-bin"
FILES_${PN}-codecs-ffmpeg-bin = "${bindir}/${BPN}/libffmpegsumo.so"

do_install_append(){
	#Chromium plugins libs to bindir
	for f in libpdf.so libosmesa.so libffmpegsumo.so; do
		if [ -f "${B}/out/${CHROMIUM_BUILD_TYPE}/$f" ]; then
			install -Dm 0644 ${B}/out/${CHROMIUM_BUILD_TYPE}/$f ${D}${bindir}/${BPN}/$f
		fi
	done
}
