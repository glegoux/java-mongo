// traces.mongo.js
//
// execution with: 
// $ mongo < traces.mongo.js

load('console.js');

print("--- end welcome message")

// use test;
db = db.getSiblingDB('test');

// insert one simple document
result = db.documents.insert({"n": 1, "message": "Hello World!"})

// print js variable (use print or printjson command)
print("---")
print(result)

// find random document among all documents,
// then print nicely from STDOUT
print("---")
db.documents.findOne()

// insert several documents
result = db.documents.insert({"n": 2, "message": "Hello World!", "a": 1, "b": 2, "c": 3, "d": 4, "e": 5, "f": 6})

// find particular document among all documents,
// then print nicely from STDOUT
print("---")
db.documents.find({"n": 2}).pretty()

// find particular document among all documents with projections,
// then print nicely from STDOUT
print("---")
db.documents.find({"n": 2}, {"message": 1})
print("---")
db.documents.find({"n": 2}, {"_id": 0, "message": 1})

print("--- beginning godbye message")
