#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))

dcos package install --options=marathon-lb-external_pkg-marathon-lb.json marathon-lb --yes