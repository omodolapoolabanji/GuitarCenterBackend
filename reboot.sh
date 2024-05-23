#!/usr/bin/env bash
REM the line above is used to specify the path to the bash interpreter


docker compose down --volumes && docker compose up --build
REM the compose down --voumes effectively cleans up any existing containers
REM the other part with the compose up builds the containers as specified in the compose file