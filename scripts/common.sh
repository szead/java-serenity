#!/bin/bash

function log()
{
  printf "\n\e[32m ---> ${1}\e[39m\n"
}
function log_error()
{
  printf "\n\e[31m ---! ${1}\e[39m\n"
}
function kill_testrunner() {
    TESTRUNNER_ID=$(docker ps -qf 'name=testrunner')
    if [ -n "$TESTRUNNER_ID" ]
    then
      docker kill "$TESTRUNNER_ID"
    fi
}

function wait_for_grid() {
    set -e

    cmd="$@"

    while ! curl -sSL "http://localhost:4444/wd/hub/status" 2>&1 \
            | jq -r '.value.ready' 2>&1 | grep "true" >/dev/null; do
        echo 'Waiting for the Grid'
        sleep 1
    done

    >&2 echo "Selenium Grid is up"
    exec $cmd
}
