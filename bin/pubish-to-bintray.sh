#!/bin/bash

clear

if [ "$1" = "" ]
then
 echo "Usage: $0 <release> <api key>"
 exit
fi
if [ "$2" = "" ]
then
 echo "Usage: $0 <release> <api key>"
 exit
fi
RELEASE=$1
KEY=$2

curl --include --request DELETE --user "kurron:${KEY}" --header "Content-Type: application/json" https://api.bintray.com/packages/kurron/maven/groovy-tools/versions/${RELEASE}

curl --include --request POST --user "kurron:${KEY}" --header "Content-Type: application/json" https://api.bintray.com/packages/kurron/maven/groovy-tools/versions --data "{ \"name\": \"${RELEASE}\", \"desc\": \"New bits!\" }"

curl --include --request PUT --user "kurron:${KEY}" --header "X-Bintray-Package:groovy-tools" --header "X-Bintray-Version:${RELEASE}" --header "Content-Type: application/octet-stream" --header "Accept:application/json" --data-binary @build/libs/tools-groovy-0.0.0-SNAPSHOT.jar https://api.bintray.com/maven/kurron/maven/groovy-tools/org/kurron/tools-groovy/${RELEASE}/tools-groovy-${RELEASE}.jar

curl --include --request PUT --user "kurron:${KEY}" --header "X-Bintray-Package:groovy-tools" --header "X-Bintray-Version:${RELEASE}" --header "Content-Type: application/octet-stream" --header "Accept:application/json" --data-binary @build/libs/tools-groovy-0.0.0-SNAPSHOT-sources.jar https://api.bintray.com/maven/kurron/maven/groovy-tools/org/kurron/tools-groovy/${RELEASE}/tools-groovy-${RELEASE}-sources.jar

curl --include --request POST --user "kurron:${KEY}" --header "Content-Type: application/json" https://api.bintray.com/content/kurron/maven/groovy-tools/${RELEASE}/publish
