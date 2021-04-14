#!/bin/bash

$HADOOP_PREFIX/etc/hadoop/hadoop-env.sh
sed -ie s/localhost/$HOSTNAME/ /usr/local/hadoop/etc/hadoop/core-site.xml
service sshd start
$HADOOP_PREFIX/sbin/start-dfs.sh
$HADOOP_PREFIX/bin/hadoop dfsadmin -safemode leave && $HADOOP_PREFIX/bin/hdfs dfs -put /files/* / && echo HDFS_IS_UP && tail -f /dev/null