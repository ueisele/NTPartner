#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))

dcos marathon app add ntpartner-mysql_service-marathon-docker.json
dcos marathon app add ntpartner-rabbitmq_service-marathon-docker.json

dcos marathon app add ntpartner-backend-setup-mysql_service-marathon-docker.json
dcos marathon app add ntpartner-backend_service-marathon-docker.json