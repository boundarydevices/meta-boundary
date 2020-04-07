#!/bin/sh
### BEGIN INIT INFO
# Provides: bluetooth-uart
# Required-Start:    $local_fs $syslog $remote_fs dbus
# Required-Stop:     $local_fs $syslog $remote_fs
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: Attaching UART to Bluez stack
### END INIT INFO
#
DESC=silex-uart

PATH=/sbin:/bin:/usr/sbin:/usr/bin

HCIATTACH=`/usr/bin/which hciattach`
HCICONFIG=`/usr/bin/which hciconfig`

ATHEROS6K_SYS=/sys/bus/sdio/drivers/ar6k_wlan/mmc*

SILEX_DEV=0x0701

SILEX_CONF=/etc/bluetooth/silex.conf

test -f /etc/default/bluetooth && . /etc/default/bluetooth

#. /lib/lsb/init-functions

set -e

pre_start()
{
  rfkill block bluetooth
  echo "rfkill on/off cycle."
  sleep .5
  rfkill unblock bluetooth
  sleep .1
}


start_silex()
{
  if [ -d ${ATHEROS6K_SYS}:1 ] ; then
    bt_dev=$(cat ${ATHEROS6K_SYS}:1/device)
    if [ -x ${HCIATTACH} ] && [ -e ${SILEX_CONF} ] && [ "${bt_dev}" = "${SILEX_DEV}" ] ; then
      echo "silex found"
    grep -v -e '^[[:space:]]*#' -e '^[[:space:]]*$' $SILEX_CONF | while read i ; do
      $HCIATTACH $i > /dev/null 2>&1
      done
    fi
  fi
}

HCIATTACH_PROC=hciattach

stop_silex()
{
  RUNNING=`ps -A | grep $HCIATTACH_PROC`
  if [ "x$RUNNING" != "x" ] ; then
    echo "killing hciattach"
    killall -q $HCIATTACH_PROC > /dev/null 2>&1
  fi
}

case $1 in
  start)
  echo "Starting $DESC"
  if test "$BLUETOOTH_ENABLED" = 0 ; then
    echo "bluetooth disabled. see /etc/default/bluetooth"
    exit 0
  fi
  pre_start
  start_silex
  exit 0
  ;;

  stop)
  echo "Stopping $DESC"
  if test "$BLUETOOTH_ENABLED" = 0 ; then
    echo "bluetooth disabled. see /etc/default/bluetooth"
    exit 0
  fi

  stop_silex
  exit 0
  ;;

  restart|force-reload)
  $0 stop
  sleep 1
  $0 start
  exit 0;
  ;;

  status)
  exit 0
  ;;

  *)
  ;;
esac

exit 0
