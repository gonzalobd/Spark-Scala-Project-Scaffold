#!/usr/bin/env bash
#abort on errors
set -xe

docker-compose -f src/test/resources/dockercompose/docker-compose.yml up -d
while ! $(docker-compose -f src/test/resources/dockercompose/docker-compose.yml logs hadoop | grep -lq HDFS_IS_UP)
do
    sleep 3
done

while ! $(docker-compose -f src/test/resources/dockercompose/docker-compose.yml logs master | grep -lq ALIVE)
do
    sleep 3
done

docker cp ../spark-etl/target/spark-etl-*-jar-with-dependencies.jar spark_master:/
docker cp ../spark-etl/src/main/resources/application.conf spark_master:/