SUMMARY = "Pachinko SDK"
DESCRIPTION = "Pachinko sdk with opengl uvd playback and tiling playback"
SECTION = "graphics"

DEPENDS = "mesa libglu glew freeglut"
RDEPENDS_${PN} = "${PN}-bins"

inherit cmake python3native

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${S}/samples/uvdPlayback/src/uvdPlayback.cpp;md5=3c9af5ec20771c86459d9788f675b0e8"

S = "${WORKDIR}/OpenGL_Pachinko_SDK"

SRC_URI = "file://OpenGL_Pachinko_SDK.tar.bz2"

EXTRA_OECMAKE += "-DCMAKE_SKIP_RPATH=TRUE"

PACKAGES =+ "${PN}-bins"

do_install() {
    # Install the binary components first
    install -d ${D}/${libdir}/${PN}
    install -m 0755 ${S}/modules/TileDecoder/lib/x86_64/Release/libTileDecoder.so ${D}/${libdir}/${PN}

    install -d ${D}${bindir}
    install ${S}/samples/tiledPlayback/bin/x86_64/Release/tiledPlayback ${D}${bindir}/tiledPlayback-OGL
    install ${S}/samples/uvdPlayback/bin/x86_64/Release/uvdPlayback ${D}${bindir}
}

FILES_${PN}-bins = "${libdir}/${PN}/*.so"
