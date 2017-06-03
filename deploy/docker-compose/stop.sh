#!/usr/bin/env bash
cd $(dirname $0)
set -e
source ./env.sh
source ./function/docker-compose.sh

function stop() {
    docker_compose_in_env stop $@
}

function main() {
    stop $@
}

main $@