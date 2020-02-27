#!/usr/bin/env bash

file=./target/github-client-1.0-SNAPSHOT.jar

if [[ ! -f "$file" ]]; then
    echo file not found. Run mvn package...
    mvn package > /dev/null
fi

java -jar ${file} ${1}
