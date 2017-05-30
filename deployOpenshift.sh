#!/bin/sh
# vorher: minishift start --vm-driver=virtualbox
oc login https://192.168.99.100:8443 --username=developer --password=developer --insecure-skip-tls-verify
oc new-project ntpartner
# oc delete all -l app=ntpartner
oc get templates -n openshift
oc new-app -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=dbuser -e MYSQL_DATABASE=ntpartner openshift/mysql-55-centos7
oc new-app rabbitmq
oc new-app wildfly:10.1~/home/user/git/NTPartner-master/ --name ntpartner
oc expose svc/ntpartner
