#!/usr/bin/env bash

PERSON_ID=$1
# PERSON_ID="09c0e3c909bd4af4a579ff61e7de9c2c"

curl -XDELETE "http://localhost:8080/api/v1/test/person/$PERSON_ID"