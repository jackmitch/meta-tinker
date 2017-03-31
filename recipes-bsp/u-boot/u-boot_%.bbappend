FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://fix-linking.patch \
"

SRCREV = "5cf618ee60a752d058a767372ca1ecb8d9c09b16"

DEPENDS += " bc-native"

do_compile_append() {

	./tools/mkimage -n rk3288 -T rksd -d spl/u-boot-spl-dtb.bin out
	cat u-boot-dtb.bin >> out
	mv out u-boot.bin
}
