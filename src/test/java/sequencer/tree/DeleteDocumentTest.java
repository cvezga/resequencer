package sequencer.tree;

import org.junit.jupiter.api.Test;
import sequencer.DocSeqComparator;
import sequencer.Document;
import sequencer.DocumentIndex;
import sequencer.Sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeleteDocumentTest extends DocumentTest {

  List<Document> documents = getDocuments();


  @Test
  public void shouldDeleteAndResequence(){

    Node root = TreeDocumentBuilder.build(documents);
    assertNotNull(documents);

    //Inactivate some documents
    DocumentIndex index = new DocumentIndex(documents);
    Document doc21 = index.getDocumentByLevelKey("2.1");
    Document doc313 = index.getDocumentByLevelKey("3.1.1");
    assertNotNull(doc21);
    assertNotNull(doc313);
    doc21.setActive(false);
    doc313.setActive(false);

    List<Document> documents2 = SequenceDocumentBuilder.getSequencedDocuments(root);

    DocumentIndex index2 = new DocumentIndex(documents2);
    assertNull(index2.getDocumentById(doc21.getId()));
    assertNull(index2.getDocumentById(doc313.getId()));

  }

}
