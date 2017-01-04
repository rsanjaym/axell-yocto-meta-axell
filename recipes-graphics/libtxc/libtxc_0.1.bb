DESCRIPTION = "Texture compression library for Mesa"
HOMEPAGE = "http://people.freedesktop.org"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://txc_dxtn.h;md5=7e803e069a5a32ab2a99876593099a7e"

SRC_URI = "git://people.freedesktop.org/~mareko/libtxc_dxtn"

S = "${WORKDIR}/git"

SRCREV = "ef07298391c6dcad843e0b13e985090c1dd76e76"

inherit autotools pkgconfig

DEPENDS += "mesa"

FILES_${PN} += "${libdir}/*"
FILES_SOLIBSDEV = ""
