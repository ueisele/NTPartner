#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))
source ./env.sh

function main () {
    log
    start_setup "ntpartner-backend.setup-mysql"
    start_service "ntpartner-backend"
}

function log() {
    echo "Starting NTPartner Backend ${VERSION_APP}..."
}

function start_setup () {
    docker-compose -f docker-compose-infra.yml -f docker-compose-app.yml up "${1:?'Specify a service to start'}"
}

function start_service () {
    docker-compose -f docker-compose-infra.yml -f docker-compose-app.yml up -d "${1:-'Specify a service to start'}"
}

main