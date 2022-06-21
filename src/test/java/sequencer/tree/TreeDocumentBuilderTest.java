package sequencer.tree;

import org.junit.jupiter.api.Test;
import sequencer.Document;
import sequencer.Sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TreeDocumentBuilderTest {

  @Test
  public void shouldCreateTreeFromListOfDocuments(){

    List<Document> documents = getDocuments();

    Node root = TreeDocumentBuilder.build(documents);

    assertNotNull(root);

  }

  private List<Document> getDocuments(){
    List<Document> documents = new ArrayList<>();

    Node root = new TreeBuilder().build(3,3,3);
    List<Sequence> sequences = SequenceBuilder.getSequence(root);

    AtomicInteger docId= new AtomicInteger(1000);
    sequences.stream().forEach( seq -> {
      Document document = new Document(docId.getAndIncrement());
      document.setSequence(seq);
      documents.add(document);
    } );

    return documents;
  }
}
