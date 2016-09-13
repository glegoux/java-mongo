package org.presentation.test;

import java.util.List;

import org.junit.Test;
import org.presentation.Helper;
import org.presentation.entities.Document;
import org.presentation.entities.EmbeddedDocument;
import org.presentation.entities.ReferencedDocument;

public class Test02Document extends AbstractTest {

  @Test
  public void test01InsertDocument() {
    Document document = new Document();

    EmbeddedDocument embeddedDocument = new EmbeddedDocument("title_01");
    document.document = embeddedDocument;
    document.addToEmbeddedDocument(new EmbeddedDocument("title_02"));
    document.addToEmbeddedDocument(new EmbeddedDocument("title_03"));

    ReferencedDocument referencedDocument = new ReferencedDocument("reference_01");
    // comment and uncomment
    getDs().save(referencedDocument);

    document.otherDocument = referencedDocument;
    // twice the same reference
    document.addToReferencedDocument(referencedDocument);
    document.addToReferencedDocument(referencedDocument);

    getDs().save(document);
  }

  @Test
  public void test02GetDocument() {
    List<ReferencedDocument> documents = getDs().find(ReferencedDocument.class).asList();
    // put breakpoint
    System.out.println(Helper.toJson(documents));
  }

}
