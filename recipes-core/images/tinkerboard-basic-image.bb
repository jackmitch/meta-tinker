DESCRIPTION = "Bare minimum Tinkerboard image"

IMAGE_INSTALL = " \
	packagegroup-core-boot \
	${ROOTFS_PKGMANAGE_BOOTSTRAP} \
	${MACHINE_EXTRA_RRECOMMENDS} \
"

inherit core-image
