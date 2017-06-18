#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))

dcos marathon app add ntpartner-mysql_service-marathon-docker.json
dcos marathon app add ntpartner-rabbitmq_service-marathon-docker.json

#curl --header "Authorization: token=$(dcos config show core.dcos_acs_token)" -L -H 'Content-Type: application/json' -X POST -d @ntpartner-backend-setup-mysql_service-chronos-docker.json http://m1.dcos/service/chronos/v1/scheduler/iso8601

dcos marathon app add ntpartner-backend-setup-mysql_service-marathon-docker.json
dcos marathon app add ntpartner-backend_service-marathon-docker.json