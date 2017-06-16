#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))

tar  czf docker.tar.gz .docker