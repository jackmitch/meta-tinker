do_compile_append() {

	./tools/mkimage -n rk3288 -T rksd -d spl/u-boot-spl-dtb.bin out
	cat u-boot-dtb.bin >> out
	mv out u-boot.bin
}
