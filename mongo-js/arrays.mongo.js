// arrays.mongo.js
//
// execution with: 
// $ mongo < arrays.mongo.js

load('console.js');

// use test;
db = db.getSiblingDB('test');

for (var i = 0; i < 5; i++) {
    db.arrays.insert({"tab": ["a", "b", "c", "d", "e"]})
}

for (var i = 0; i < 5; i++) {
    db.arrays.insert({"tab": ["1", "2", "3"]})
}

db.students.update(
   {},
   { $set: { "arrays" : 82 } }
)


db.arrays.update(
    {},
    {
      $push: {
         tab: {
            $each: [ "A", "B" ],
            $position: $.tab.indexOf("c")
         }
      }
    },
   {multi: true}
)

db.arrays.update(
   {},
   { $push: { tab: { $each: [ 90, 92, 85 ], $position: 1 } } },
   {multi: true}
)

db.arrays.update(
   {},
   { $push: { tab: { $each: [], $slice: -1 } } },
   {multi: true}
)

db.collection.update(
   { },
   { "$set": { "tab.$" : value } },
   false,
   true
)

db.arrays.find().forEach( function(doc) { print(doc.tab.indexOf("c")); } )

db.arrays.remove({})

db.arrays.find()

db.arrays.update(
    {},
    { $pullAll: { tab: [ "A", "a", "d" ] } },
    {multi: true}
)

db.arrays.update(
    {},
    { $addToSet: { tab: { $each: [ "A", "B", "a", "c" ]} } },
    {multi: true}
)
