SUMMARY = "Pachinko SDK"
DESCRIPTION = "Pachinko sdk with vulkan decode app, vulkan playback and tiling playback"
SECTION = "graphics"

DEPENDS = "vulkan-loader-layers amdvlk pachinko-dep"

inherit cmake python3native

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${S}/samples/simpleDecoder/src/decodeH264.cpp;md5=634c31ed71556840bdab9f0b9ff58cba"

S = "${WORKDIR}/Vulkan_Pachinko_SDK_1.0-Alpha"

SRC_URI = "file://Vulkan_Pachinko_SDK_1.0-Alpha.tar.bz2"

do_install() {
	install -d ${D}${bindir}
	install ${S}/samples/simpleDecoder/bin/x86_64/Release/simpleDecoder ${D}${bindir}
	install ${S}/samples/tiledPlayback/bin/x86_64/Release/tiledPlayback ${D}${bindir}
	install ${S}/samples/vulkanPlayback/bin/x86_64/Release/vulkanPlayback ${D}${bindir}
}
