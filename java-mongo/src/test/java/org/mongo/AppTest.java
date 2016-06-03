package org.mongo;

import static java.lang.String.format;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

public class AppTest extends AbstractTest {

  @Test
  public void testInsert() {
    getDs().save(new User("gilles"));
  }

  @Entity("users")
  private static final class User {

    @Id
    private ObjectId id;
    private String name;

    private User() {}

    private User(final String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return format("User{name='%s'}", name);
    }

  }

}
