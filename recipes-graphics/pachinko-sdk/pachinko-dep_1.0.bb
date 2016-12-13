SUMMARY = "Pachinko DEP"
DESCRIPTION = "pachinko-sdk dependent library and headers"
SECTION = "graphics"

DEPENDS = "vulkan-loader-layers"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${S}/samples/simpleDecoder/src/decodeH264.cpp;md5=634c31ed71556840bdab9f0b9ff58cba"

S = "${WORKDIR}/Vulkan_Pachinko_SDK_1.0-Alpha"

SRC_URI = "file://Vulkan_Pachinko_SDK_1.0-Alpha.tar.bz2"

do_install() {
	install -vd ${D}/${libdir}
	install -m 0755 ${S}/modules/TileDecoder/lib/x86_64/Release/libTileDecoder.so ${D}/${libdir}
	install -m 0644 ${S}/thirdParty/openh264/lib/linux/libopenh264.a ${D}/${libdir}
	install -vd ${D}${includedir}

	install -m 0755 ${S}/thirdParty/openh264/inc/codec/api/svc/*.h ${D}${includedir}
	install -m 0755 ${S}/thirdParty/openh264/inc/codec/common/inc/*.h ${D}${includedir}
	install -m 0755 ${S}/thirdParty/openh264/inc/codec/decoder/core/inc/*.h ${D}${includedir}
	install -m 0755 ${S}/thirdParty/openh264/inc/codec/decoder/plus/inc/welsDecoderExt.h ${D}${includedir}
}


INSANE_SKIP_${PN} += "already-stripped"
INSANE_SKIP_${PN} += "ldflags"

FILES_${PN} += "${libdir}"
FILES_SOLIBSDEV = ""
