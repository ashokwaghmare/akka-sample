#!/bin/bash

#  -Xloggc:/tmp/adis-build-gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps - Add in case of memory issues for profiling.

java -Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=1024M -Dfile.encoding=UTF-8 -jar `dirname $0`/launcher/sbt-launch.jar "$@"
