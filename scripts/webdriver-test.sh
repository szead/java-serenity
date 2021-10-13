#!/bin/bash

source scripts/common.sh
export COMPOSE_PROJECT_NAME=java-serenity
export COMPOSE_FILE="docker-compose.yml"

TESTRUNNER_ID=$(docker ps -qf 'name=testrunner')
log "RUNNING E2E TESTS"
docker exec -it "$TESTRUNNER_ID" ./gradlew build

