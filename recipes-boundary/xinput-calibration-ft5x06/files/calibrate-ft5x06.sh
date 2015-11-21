#!/bin/sh

xDIMENS=`DISPLAY=:0 xdpyinfo | grep dimensions | awk '{print $2}' | awk -Fx '{print $1}'`
yDIMENS=`DISPLAY=:0 xdpyinfo | grep dimensions | awk '{print $2}' | awk -Fx '{print $2}'`

DISPLAY=:0 xinput set-int-prop "ft5x06" "Evdev Axis Calibration" 32 0 $xDIMENS 0 $yDIMENS
