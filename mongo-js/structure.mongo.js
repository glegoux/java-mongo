// structure.mongo.js
//
// execution with:
// $ mongo < structure.mongo.js

load('console.js');

// use test;
db = db.getSiblingDB('test');

info('--- databases');

// show databases; or show dbs;
printjson(db.adminCommand('listDatabases'));

// use new_database;
db = db.getSiblingDB('new_database');

info('---');

// show collections;
printjson(db.getCollectionNames());

info('--- new_database collection');

// show collections;
printjson(db.getCollectionNames());

info('---');

printjson(db.newCollection.insert({}));

info('--- databases');

// show collections;
printjson(db.getCollectionNames());
