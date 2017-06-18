#!/usr/bin/env bash
set -e
cd $(readlink -f $(dirname $0))

dcos package install --options=pkg-chronos.json chronos --yes