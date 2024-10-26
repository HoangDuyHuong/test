#!/usr/bin/env python3
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
pin = 18  # Sử dụng chân GPIO 18
GPIO.setup(pin, GPIO.OUT)

try:
    while True:
        GPIO.output(pin, GPIO.HIGH)  # Bật đèn
        time.sleep(1)
        GPIO.output(pin, GPIO.LOW)   # Tắt đèn
        time.sleep(1)
except KeyboardInterrupt:
    GPIO.cleanup()
