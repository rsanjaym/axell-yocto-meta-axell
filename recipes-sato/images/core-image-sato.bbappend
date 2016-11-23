EXTRA_AXELL_PACKAGES = "amdvlk vulkan-simpledecoder"
IMAGE_INSTALL_append_amdfalconx86 = "${@' ${EXTRA_AXELL_PACKAGES}' if bb.utils.to_boolean('${INCLUDE_VULKAN}') else ''}"

# Tweaks to reduce the root filesystem footprint and apply a Limit of 500MB
python () {
    if d.getVar("AXELL_MINIMAL_IMAGE", True) == "yes":
        d.setVar("IMAGE_FEATURES_remove", "tools-profile")
        d.setVar("IMAGE_INSTALL_remove", "mesa-demos vulkan-samples")
        d.setVar("IMAGE_ROOTFS_EXTRA_SPACE", "10240")
        d.setVar("IMAGE_ROOTFS_MAXSIZE", "512000")
        d.setVar("INCLUDE_CODEXL", "no")
        d.setVar("INCLUDE_COMMERCIAL_MULTIMEDIA", "no")
        d.setVar("INCLUDE_MPV", "no")
}
