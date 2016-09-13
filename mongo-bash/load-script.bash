#!/usr/bin/env bash

echo "-- Eval inline command, then load script js:"
mongo --shell --eval "print('loading eval');quit();" init.mongo.js

echo -e "\n-- Load script js, then inline command:"
mongo --shell --eval "load('init.mongo.js');print('loading eval');quit()"

mongo --shell --eval "print('\n-- File content');cat('load-script.bash');"
