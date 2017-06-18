#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))

docker run --rm mikewright/cqlsh --cqlversion=3.4.0 -e "CREATE KEYSPACE IF NOT EXISTS metrics WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };" ${1:?'Missing cassandra host as first parameter!'}