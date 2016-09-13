#!/usr/bin/env bash

mongo --shell --eval "cat('system.bash');"
# System commands allow in mongo client:
# > ls();
# > cat('pathname');
# > pwd();
# > hostname();
# > mkdir('pathname');
# ...
