#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))

dcos marathon app add nexus3_service-marathon-docker.json
