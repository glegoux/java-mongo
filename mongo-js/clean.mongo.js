// clean.mongo.js
//
// execution with: 
// $ mongo < clean.mongo.js

load('console.js');

// use test;
db = db.getSiblingDB('test');
db.dropDatabase();

// use new_database;
db = db.getSiblingDB('new_database');
db.dropDatabase();
