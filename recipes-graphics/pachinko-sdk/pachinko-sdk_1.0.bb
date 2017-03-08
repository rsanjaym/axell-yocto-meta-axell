SUMMARY = "Pachinko SDK"
DESCRIPTION = "Pachinko sdk with vulkan decode app, vulkan playback and tiling playback"
SECTION = "graphics"

DEPENDS = "vulkan-loader-layers amdvlk"
RDEPENDS_${PN} = "${PN}-bins"

inherit cmake python3native

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${S}/samples/simpleDecoder/src/decodeH264.cpp;md5=c26442a8d8213b8ebc4432cffd25de1b"

S = "${WORKDIR}/Vulkan_Pachinko_SDK"

SRC_URI = "file://Vulkan_Pachinko_SDK.tar.bz2 \
           file://0001-tiledPlayback-fix-path-searching-for-TileDecoder.patch"

EXTRA_OECMAKE += "-DCMAKE_SKIP_RPATH=TRUE"

PACKAGES =+ "${PN}-bins"

do_install() {
    # Install the binary components first
    install -d ${D}/${libdir}
    install -m 0755 ${S}/modules/TileDecoder/lib/x86_64/Release/libTileDecoder.so ${D}/${libdir}
    install -m 0644 ${S}/thirdParty/openh264/lib/linux/libopenh264.a ${D}/${libdir}

    install -d ${D}${includedir}
    find ${S}/thirdParty/openh264/inc -name *.h -exec install -m 0644 {} ${D}${includedir} \;

	install -d ${D}${bindir}
	install ${S}/samples/simpleDecoder/bin/x86_64/Release/simpleDecoder ${D}${bindir}
	install ${S}/samples/tiledPlayback/bin/x86_64/Release/tiledPlayback ${D}${bindir}
	install ${S}/samples/vulkanPlayback/bin/x86_64/Release/vulkanPlayback ${D}${bindir}
}

FILES_${PN}-bins = "${libdir}/*.so"
