package org.presentation.entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("referenced_documents")
public class ReferencedDocument {
  
  @Id
  public ObjectId id;

  public String reference;
  
  public ReferencedDocument() {};
  
  public ReferencedDocument(String reference) {
    this.reference = reference;
  }
  
}
