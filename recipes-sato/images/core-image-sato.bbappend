EXTRA_AXELL_PACKAGES = "amdvlk vulkan-simpledecoder"
IMAGE_INSTALL_append_amdfalconx86 = "${@' ${EXTRA_AXELL_PACKAGES}' if bb.utils.to_boolean('${INCLUDE_GAMING_COMPONENTS}') else ''}"
