DESCRIPTION = "AMD Vulkan Library"
LICENSE = "BSD"
RDEPENDS_${PN} = "libdrm vulkan-loader-layers"

LIC_FILES_CHKSUM = "file://amdvulkan-lib/etc/vulkan/icd.d/amd_icd64.json;md5=afe65faab561beb34ccbf23340c2c53e \
"

SRC_URI = "file://amdvulkan-lib.tar.bz2 \
"

PR = "r0"
PV = "1.0"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${sysconfdir}/vulkan/
    install -d ${D}/${sysconfdir}/vulkan/icd.d
    install -m 0644 amdvulkan-lib/etc/vulkan/icd.d/amd_icd64.json ${D}/${sysconfdir}/vulkan/icd.d/
    install -vd ${D}/${libdir}
    install -m 0755 amdvulkan-lib/opt/amdgpu-pro/lib/x86_64-linux-gnu/*.so ${D}/${libdir}
}

INSANE_SKIP_${PN} += "already-stripped"
INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN} += "installed-vs-shipped"

FILES_${PN} = "${sysconfdir}/vulkan"
FILES_${PN} = "${sysconfdir}/vulkan/icd.d"
FILES_${PN} += "${libdir}"
FILES_SOLIBSDEV = ""
