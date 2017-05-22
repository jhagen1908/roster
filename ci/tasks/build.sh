#!/bin/bash

set -eu

version=`cat version/number`

cd roster

mvn package

mv target/roster.jar build/roster-${version}.jar
