#!/bin/sh
# vorher: minishift start --vm-driver=virtualbox
oc login https://192.168.99.100:8443 --username=developer --password=developer --insecure-skip-tls-verify
oc new-project ntpartner
# oc delete all -l app=ntpartner
oc get templates -n openshift
oc new-app -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=dbuser -e MYSQL_DATABASE=ntpartner openshift/mysql-55-centos7
oc new-app rabbitmq
oc new-app wildfly:10.1~https://github.com/pkutschera/NTPartner#openshift -e SPRING_PROFILES_ACTIVE=openshift --name ntpartner
# Build scheduled, use 'oc logs -f bc/ntpartner' to track its progress.
oc expose svc/ntpartner
