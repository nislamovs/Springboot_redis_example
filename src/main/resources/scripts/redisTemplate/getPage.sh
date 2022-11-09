#!/usr/bin/env bash

START=$1
END=$2
# PERSON_ID="09c0e3c909bd4af4a579ff61e7de9c2c"

curl -XGET "http://localhost:8080/api/v1/test/person?start=$START&end=$END"