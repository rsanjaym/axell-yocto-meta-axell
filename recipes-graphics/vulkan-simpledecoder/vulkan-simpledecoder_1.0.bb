SUMMARY = "Vulkan Simple Decoder"
DESCRIPTION = "Sample Vulkan app for simple H.264 decoding."
SECTION = "graphics"

DEPENDS = "vulkan-loader-layers amdvlk"

inherit cmake python3native

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${S}/src/decodeH264.cpp;beginline=1;endline=24;md5=83f80551db30e61fe6372e0703af2160"

S = "${WORKDIR}/simpleDecoder"

SRC_URI = "file://simpleDecoder_1.0Alpha.zip \
	   file://0001-simpledecoder-fix-build-for-OE.patch"

do_install() {
	install -d ${D}${bindir}
	install ${B}/bin/simpleDecoder ${D}${bindir}
}
