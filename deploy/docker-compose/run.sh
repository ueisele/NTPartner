#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))

./up-infra.sh
sleep 10
./up-app.sh

./docker-ips.sh