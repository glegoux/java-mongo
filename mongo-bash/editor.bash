#!/usr/bin/env bash

export EDITOR=vim
mongo --shell --eval "cat('editor.bash')"
# edit object in mongo client:
# > o = {}
# > edit o <- {"a": 1, "b": 2}
# write function in mongo client:
# > function f() {
#  print('Hello world!');
# }
# > f()
