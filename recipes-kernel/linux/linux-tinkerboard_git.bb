DESCRIPTION = "Mainline Tinkerboard RK3288 Linux Kernel"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

S = "${WORKDIR}/git"

KBRANCH_tinkerboard = "linux-4.12.y"

LINUX_VERSION ?= "4.12.2"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRCREV = "ab35d16f66d63b625396edfba013dd258e13f560"
SRCREV_FORMAT = "kernel"

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;name=kernel;branch=${KBRANCH} \
"

COMPATIBLE_MACHINE = "tinker"

do_configure_prepend() {
	cp ${S}/arch/arm/configs/multi_v7_defconfig ${B}/.config
	echo "CONFIG_GPIO_SYSFS=y" >> ${B}/.config
}

do_install_append() {
    oe_runmake headers_install \
	INSTALL_HDR_PATH=${D}${exec_prefix}/src/linux-${KERNEL_VERSION} ARCH=$ARCH
}

PACKAGES =+ "kernel-headers"
FILES_kernel-headers = "${exec_prefix}/src/linux*"

require recipes-kernel/linux/linux-dtb.inc
