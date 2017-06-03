#!/usr/bin/env bash
cd $(dirname $0)
set -e
source ./env.sh
source ./function/docker-compose.sh

function main() {
    docker_compose_in_env $@
}

main $@