package org.presentation.test;

import org.junit.After;
import org.junit.Before;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public abstract class AbstractTest {

  public static final String TEST_DB_NAME = "mongo_java";
  private final MongoClient mongoClient;
  private final Morphia morphia = new Morphia();
  private DB db;
  private Datastore ds;

  protected AbstractTest() {
    try {
      mongoClient = new MongoClient(new MongoClientURI(System.getProperty("MONGO_URI", "mongodb://127.0.0.1:27017")));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Before
  public void setUp() {
    setDb(getMongoClient().getDB(TEST_DB_NAME));
    setDs(getMorphia().createDatastore(getMongoClient(), getDb().getName()));
  }

  // @After
  public void tearDown() {
    cleanup();
    getMongoClient().close();
  }

  protected void cleanup() {
    DB db = getDb();
    if (db != null) {
      db.dropDatabase();
    }
  }

  public DB getDb() {
    return db;
  }

  public void setDb(DB db) {
    this.db = db;
  }

  public Morphia getMorphia() {
    return morphia;
  }

  public Datastore getDs() {
    return ds;
  }

  public void setDs(Datastore ds) {
    this.ds = ds;
  }

  public MongoClient getMongoClient() {
    return mongoClient;
  }

}
