#!/bin/sh
cf login a  https://api.ng.bluemix.net

cf unbind-service ntpartner my_mysql
cf unbind-service ntpartner my_rabbitmq

cf delete-service my_mysql
cf delete-service my_rabbitmq

cf create-service cleardb spark my_mysql
cf create-service cloudamqp lemur my_rabbitmq
cf push ntpartner