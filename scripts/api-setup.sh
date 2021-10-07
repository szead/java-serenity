#!/bin/bash

source scripts/common.sh
export COMPOSE_PROJECT_NAME=java-serenity
export COMPOSE_FILE="docker-compose.yml"

log "STOPPING CONTAINERS"
kill_testrunner
docker-compose down --remove-orphans --volumes

log "BUILDING IMAGES"
if [ -z "$SKIP_PULL" ]; then
  docker-compose build --pull
else
  docker-compose build
fi

log "STARTING CONTAINERS"
docker-compose up -d

docker-compose run --no-deps --rm -d testrunner tail -f /dev/null
TESTRUNNER_ID=$(docker ps -qf 'name=testrunner')

echo "$TESTRUNNER_ID"

log "LOCAL SETUP IS COMPLETE, NOW RUN THE TESTS WITH ./scripts/api-test.sh"
