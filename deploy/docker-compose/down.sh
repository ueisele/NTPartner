#!/usr/bin/env bash
cd $(dirname $0)
set -e
source ./env.sh
source ./function/docker-compose.sh

function down() {
    docker_compose_in_env down --remove-orphans $@
}

function main() {
    down $@
}

main $@