#!/bin/bash
source ./scripts/common.sh

export COMPOSE_PROJECT_NAME=java-serenity
export COMPOSE_FILE="docker-compose.yml"
export COMPOSE_PROFILES="webdriver"

set -e
DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"
cd $DIR/..

log "STOPPING AND REMOVING TEST CONTAINERS"
kill_testrunner
docker-compose down --remove-orphans --volumes

log "DONE!"
