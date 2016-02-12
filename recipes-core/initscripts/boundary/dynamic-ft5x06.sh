#!/bin/sh

SCREENMODE=`cat /sys/class/graphics/fb0/mode`
case "$1" in
start)
        if [[ $SCREENMODE == *"1280"* ]]
        then
                echo "options ft5x06_ts screenres=1280,800" > /etc/modprobe.d/ft5x06_ts.conf
                echo "-----Setting 1280x800 screenres for ft5x06 modprobe"
                modprobe -r ft5x06_ts
                modprobe ft5x06_ts
        elif [[ $SCREENMODE == *"1024"* ]]
        then
                echo "options ft5x06_ts screenres=1024,600" > /etc/modprobe.d/ft5x06_ts.conf
                echo "-----Setting 1024x600 screenres for ft5x06 modprobe"
                modprobe -r ft5x06_ts
                modprobe ft5x06_ts
        else
                echo "-----Dynamic-ft5x06 Error"
        fi
esac
exit 0
