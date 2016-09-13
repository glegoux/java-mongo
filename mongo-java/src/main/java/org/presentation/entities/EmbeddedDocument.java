package org.presentation.entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public class EmbeddedDocument {

  @Id
  public ObjectId id;

  public String title;

  public EmbeddedDocument() {};

  public EmbeddedDocument(String title) {
    this.title = title;
  }

}
