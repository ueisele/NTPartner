#!/usr/bin/env bash
source ./.env
export VERSION_APP=$(git describe --tags)

PROJECT_NAME="${COMPOSE_PROJECT_NAME}"
PROJECT_NETWORK="${COMPOSE_PROJECT_NAME}_default"