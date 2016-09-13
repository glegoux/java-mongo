#!/usr/bin/env bash
#
# Install MongoDB on Ubuntu 14.04:
# https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/ 

# MongoDB 2: 2.6.12
# MongoDB 3: 3.2.7 
version=${1:-"latest"}

# 1. Import the public key used by the package management system

if [ ${version} = "latest" ]; then
  sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
else
  sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
fi

# 2. Create a list file for MongoDB

if [ ${version} = "latest" ]; then
  echo "deb http://repo.mongodb.org/apt/ubuntu trusty/mongodb-org/3.2 multiverse" \
    | sudo tee /etc/apt/sources.list.d/mongodb-org-3.2.list
else
  echo "deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen" \
    | sudo tee /etc/apt/sources.list.d/mongodb.list
fi


# 3. Reload local package database

sudo apt-get update

# 4. Install the MongoDB packages

if [ ${version} = "latest" ]; then
  sudo apt-get install -y mongodb-org
else
  sudo apt-get install -y \
    mongodb-org="${version}" \
    mongodb-org-server="${version}" \
    mongodb-org-shell="${version}" \
    mongodb-org-mongos="${version}" \
    mongodb-org-tools="${version}"
fi
