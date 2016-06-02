#!/usr/bin/env bash

mvn archetype:generate \
  -DgroupId=org.mongo -DartifactId=java-mongo \
  -DpackageName=org.mongo.javamongo -Dversion=1.0.0-SNAPSHOT
