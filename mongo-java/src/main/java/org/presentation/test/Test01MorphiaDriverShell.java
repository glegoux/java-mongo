package org.presentation.test;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import com.mongodb.BasicDBObject;

public class Test01MorphiaDriverShell extends AbstractTest {

  // Morphia

  @Entity("users")
  // @Entity(value="users", noClassnameStored = true)
  private static final class User {

    @Id
    private ObjectId id;
    // @Property("nickname")
    private String name;
    private String source;

    private User() {
      source = "morphia";
    }

    private User(final String name) {
      this.name = name;
      source = "morphia";
    }

  }

  @Test
  public void test01InsertMorphia() {
    getDs().save(new User());
    getDs().save(new User("come"));
  }

  // Java Driver Mongo

  @Test
  public void test02InsertDriver() {

    BasicDBObject document = new BasicDBObject();
    document.put("name", "mateo");
    document.put("source", "java-driver-mongo");

    getDb().getCollection("users").insert(document);
  }

  // Request in Mongo Shell

  /**
   * Insert User:
   * 
   * db.users.insert({"name": "severin", "source": "mongo-shell"})
   * 
   * Find all users:
   * 
   * db.users.find().pretty()
   * 
   * Remove all users:
   * 
   * db.users.remove({})
   * 
   */

}
