package org.presentation.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("documents")
public class Document extends AbstractDocument {

  @Id
  public ObjectId id;

  // default value null => absent in database
  public String name;

  // default value 0
  public int i;

  // default value 0
  public long l;

  // default value 0
  public float f;

  // default value 0
  public double d;

  // default value null => absent in database
  public String s;

  // default value null => absent in database
  public List<String> ls;

  // default value null => absent in database
  public Set<Long> sl;

  // default value null => absent in database
  public Map<String, Float> msf;

  // default value null => absent in database
  @Embedded
  public EmbeddedDocument document;

  // default value null => absent in database
  @Embedded
  public List<EmbeddedDocument> documents;

  // default value null => absent in database
  @Reference
  public ReferencedDocument otherDocument;

  // default value null => absent in database
  @Reference
  public List<ReferencedDocument> otherDocuments;

  public Document() {};

  public Document(String name) {
    this.name = name;
  }

  public void addToEmbeddedDocument(EmbeddedDocument document) {
    if (documents == null)
      documents = new ArrayList<>();
    documents.add(document);
  }

  public void addToReferencedDocument(ReferencedDocument document) {
    if (otherDocuments == null)
      otherDocuments = new ArrayList<>();
    otherDocuments.add(document);
  }

}
