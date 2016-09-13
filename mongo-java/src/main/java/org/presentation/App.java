package org.presentation;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.presentation.entities.Document;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class App {

  public static final class IMongoConfig {

    // VM on VirtualBox with Network Bridged Adapter (PRIMARY)
    public final String IPV4_VM1 = "192.168.1.35";
    // VM on VirtualBox with Network Bridged Adapter (SECONDARY and ARBITER)
    public final String IPV4_VM2 = "192.168.1.29";

    List<ServerAddress> getServerAddresses() {
      List<ServerAddress> serverAddresses = new ArrayList<ServerAddress>();
      ServerAddress serverAddress01 = new ServerAddress(IPV4_VM1, 27017);
      ServerAddress serverAddress02 = new ServerAddress(IPV4_VM2, 27017);
      serverAddresses.add(serverAddress01);
      serverAddresses.add(serverAddress02);
      return serverAddresses;
    }

    List<MongoCredential> getCredentials() {
      return new ArrayList<>();
    }

    MongoClientOptions getOptions() {
      return MongoClientOptions.builder().connectTimeout(5000).build();
    }

  }

  public static void main(String[] args) {

    IMongoConfig mongoConfig = new IMongoConfig();
    MongoClient mongoClient = new MongoClient(mongoConfig.getServerAddresses(), mongoConfig.getCredentials(), mongoConfig.getOptions());
    DB db = mongoClient.getDB("mongo_java");
    Morphia morphia = new Morphia();
    Datastore ds = morphia.createDatastore(mongoClient, db.getName());

    // Change according to VM1 or VM2 is out
    ds.save(new Document("TEST"));

  }

}
