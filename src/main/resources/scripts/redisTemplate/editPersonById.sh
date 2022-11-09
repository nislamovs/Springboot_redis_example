#!/usr/bin/env bash

curl -XPOST "http://localhost:8080/api/v1/test/generate?timeout=1000" | jq . > editablePerson.json ;

cat ./editablePerson.json | jq .

PERSON_ID=$(cat ./editablePerson.json | jq .id | tr -d '"')
echo ">>>   $PERSON_ID\n"

# Change lastname
NEW_LASTNAME="petrov"
jq '.lastname = "'"$NEW_LASTNAME"'"' ./editablePerson.json > ./editedPerson.json
rm ./editablePerson.json

curl -XPUT \
-H "Content-type: application/json" \
-H "Accept: application/json" \
--data @./editedPerson.json \
"http://localhost:8080/api/v1/test/person/$PERSON_ID"