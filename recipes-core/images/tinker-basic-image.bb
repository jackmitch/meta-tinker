DESCRIPTION = "Bare minimum Tinkerboard image"

IMAGE_INSTALL = " \
	packagegroup-core-boot \
	${MACHINE_EXTRA_RRECOMMENDS} \
"

inherit core-image
