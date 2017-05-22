#!/bin/bash

set -e

if [ "$1" = "" ]; then
  echo $0: usage: $0 concourse-target 
  exit
fi

credentials=~/.credentials.yml

if [ ! -e  $credentials ]; then
  echo $0: Credential file does not exist: $credentials
  exit
fi

cat $credentials > temp-config.yml
cat config.yml >> temp-config.yml

fly -t $1 set-pipeline -c pipeline.yml -l temp-config.yml -p roster-app -n

fly -t $1 unpause-pipeline -p roster-app

rm temp-config.yml
