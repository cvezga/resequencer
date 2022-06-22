package sequencer.tree;

import sequencer.Document;
import sequencer.Sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractDocumentTest {

  protected List<Document> getDocuments(){
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
