#!/usr/bin/env bash
#abort on errors
set -xe

docker-compose -f src/test/resources/dockercompose/docker-compose.yml up -d
while ! $(docker-compose -f src/test/resources/dockercompose/docker-compose.yml logs hadoop | grep -lq HDFS_IS_UP)
do
    sleep 3
done