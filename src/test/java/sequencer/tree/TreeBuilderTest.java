package sequencer.tree;

import org.junit.jupiter.api.Test;
import sequencer.DocSeqComparator;
import sequencer.Document;
import sequencer.DocumentIndex;
import sequencer.Sequence;

import java.util.Collections;
import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeBuilderTest {

  @Test
  public void shouldCreateTree() {

    Node root = new TreeBuilder().build(3,3, 5);

    List<Sequence> sequences = SequenceBuilder.getSequence(root);

    sequences.stream().forEach( s -> out.println(s.getSequenceString()) );

  }

  @Test
  public void shouldReSequenceOnlyForActiveDocuments() {

    Node root = new TreeBuilder().build(3,2, 3);

    out.println("===== BEFORE INACTIVE DOCUMENT =====");
    List<Document> documents = SequenceDocumentBuilder.getSequencedDocuments(root);

    //Documets allready are sorted but level key; but just to show the use on
    Collections.sort(documents, new DocSeqComparator());

    documents.stream().forEach( out::println );

    DocumentIndex index = new DocumentIndex(documents);

    //Inactivate some documents
    Document doc21 = index.getDocumentByLevelKey("2.1");
    Document doc313 = index.getDocumentByLevelKey("3.1.3");
    assertNotNull(doc21);
    assertNotNull(doc313);
    doc21.setActive(false);
    doc313.setActive(false);

    out.println("===== INACTIVE DOCUMENTS =====");
    out.println(doc21);
    out.println(doc313);

    out.println("===== RE-SEQUENCED DOCUMENTS =====");
    List<Document> documents2 = SequenceDocumentBuilder.getSequencedDocuments(root);
    documents2.stream().forEach( out::println );

    DocumentIndex index2 = new DocumentIndex(documents2);
    assertNull(index2.getDocumentById(doc21.getId()));
    assertNull(index2.getDocumentById(doc313.getId()));

  }


}
