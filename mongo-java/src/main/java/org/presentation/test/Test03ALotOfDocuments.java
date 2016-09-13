package org.presentation.test;

import org.junit.Test;
import org.presentation.entities.Document;

public class Test03ALotOfDocuments extends AbstractTest {

  @Test
  public void test01InsertDocuments() {
    for (int i = 0; i < 1000; i++) {
      getDs().save(new Document());
    }
  }

}
