#!/usr/bin/env bash

export JAVA_HOME=/usr/lib/jvm/java-15-oracle

#Cleanup
./stop_n_remove_containers.sh ;
./docker_total_cleanup.sh ;


#Stop on error
set -e ;

#Go to project root folder
cd .. ;


#Build docker image
./gradlew clean build docker -x test;
cd - ;


#Launch all docker chain
docker-compose up ;
