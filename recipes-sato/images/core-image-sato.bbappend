IMAGE_INSTALL_append_amdfalconx86 = "${@' amdvlk' if bb.utils.to_boolean('${INCLUDE_GAMING_COMPONENTS}') else ''}"
