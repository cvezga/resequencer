package sequencer.tree;

import org.junit.jupiter.api.Test;
import sequencer.DocumentSequencer;
import sequencer.entity.Document;
import sequencer.tree.test.SequenceDocumentBuilder;
import sequencer.tree.test.TreeGenerator;
import sequencer.util.Timer;

import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class PerformanceTest {

  @Test
  public void bigDocumentListTest() {

    Node<Document> root =  new TreeGenerator().build(200_000,3,5);

    List<Document> documents = SequenceDocumentBuilder.getSequencedDocuments(root);

    out.println("Document size: "+documents.size());

    Collections.reverse(documents);

    Timer t = new Timer();
    t.start("DocumentSequencer.sequence()");
    List<Document> sequencedDocuments = DocumentSequencer.sequence(documents);
    t.end();


  }

}
