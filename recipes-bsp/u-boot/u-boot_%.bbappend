FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://fix-linking.patch \
	file://0001-rockchip-use-spl_early_init-instead-of-spl_init.patch \
	file://0001-spl-add-spl_early_init.patch \
	file://fix-mmc.patch \
"

SRCREV = "${AUTOREV}"

do_compile_append() {

	./tools/mkimage -n rk3288 -T rksd -d spl/u-boot-spl-dtb.bin out
	cat u-boot-dtb.bin >> out
	mv out u-boot.bin
}
