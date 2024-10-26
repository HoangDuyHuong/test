DESCRIPTION = "A script and service to blink an LED using GPIO on Raspberry Pi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file:///home/huong/yocto-build/poky/meta-custom/recipes-core/gpio-blink/files/LICENSE;md5=ec3f44ee04d4667b89c1cf780be28daf"

SRC_URI = "file://gpio_blink.py \
           file://start_gpio.sh \
           file://gpio_blink.service \
           file://LICENSE"

do_install() {
    install -d ${D}/usr/local/bin
    install -m 0755 ${WORKDIR}/gpio_blink.py ${D}/usr/local/bin/
    install -m 0755 ${WORKDIR}/start_gpio.sh ${D}/usr/local/bin/
    install -d ${D}/etc/systemd/system
    install -m 0644 ${WORKDIR}/gpio_blink.service ${D}/etc/systemd/system/
    install -d ${D}/usr/share/licenses/gpio-blink
    install -m 0644 ${WORKDIR}/LICENSE ${D}/usr/share/licenses/gpio-blink/
}

FILES_${PN} += "/usr/local/bin/gpio_blink.py /usr/local/bin/start_gpio.sh /etc/systemd/system/gpio_blink.service /usr/share/licenses/gpio-blink/LICENSE"

