#!/usr/bin/env bash

# PERSON_ID=$1
PERSON_ID="fbe69398e9ab40ddb30d7e207e8091bc"

curl -XDELETE "http://localhost:8080/api/v1/person/$PERSON_ID"