#!/bin/sh
cf login -u user -p pass -a https://api.local.pcfdev.io --skip-ssl-validation

cf unbind-service ntpartner my_mysql
cf unbind-service ntpartner my_rabbitmq

cf delete-service my_mysql
cf delete-service my_rabbitmq

cf create-service p-mysql 512mb my_mysql
cf create-service p-rabbitmq standard my_rabbitmq
cf push ntpartner