DESCRIPTION = "Mainline Tinkerboard RK3288 Linux Kernel"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

S = "${WORKDIR}/git"

KBRANCH_tinkerboard = "v4.12-armsoc/dts32"

LINUX_VERSION ?= "4.9"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRCREV_FORMAT = "kernel"

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/mmind/linux-rockchip.git;name=kernel;branch=${KBRANCH} \
"

COMPATIBLE_MACHINE = "tinker"

do_configure_prepend() {
	cp ${S}/arch/arm/configs/multi_v7_defconfig ${B}/.config
}

do_install_append() {
    oe_runmake headers_install \
	INSTALL_HDR_PATH=${D}${exec_prefix}/src/linux-${KERNEL_VERSION} ARCH=$ARCH
}

PACKAGES =+ "kernel-headers"
FILES_kernel-headers = "${exec_prefix}/src/linux*"

require recipes-kernel/linux/linux-dtb.inc
