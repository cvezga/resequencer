package sequencer;

import org.junit.jupiter.api.Test;
import sequencer.tree.Node;
import sequencer.tree.SequenceBuilder;
import sequencer.tree.SequenceDocumentBuilder;
import sequencer.tree.TreeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTest {

  @Test
  public void orderTest() {

    Node root = new TreeBuilder().build(200_000,3,5);

    List<Sequence> sequences = SequenceBuilder.getSequence(root);

    out.println("===== Reversed List =====");
    Collections.reverse(sequences);
    sequences.stream().forEach( s -> out.println(s.getSequenceString()));

    out.println("===== Sorted List =====");
    long t = System.currentTimeMillis();
    Collections.sort(sequences, new SeqComparator());
    long tt = System.currentTimeMillis() - t;
    sequences.stream().forEach( s -> out.println(s.getSequenceString()));
    out.println("Sort took: "+tt+"ms");
  }

  @Test
  public void orderDocumentsTest() {

    Node root = new TreeBuilder().build(200_000,3,5);

    List<Document> documents = SequenceDocumentBuilder.getSequencedDocuments(root);

    out.println("===== Reversed List =====");
    Collections.reverse(documents);
    //documents.stream().forEach( d -> out.println(d.getSequenceString()));

    out.println("===== Sorted List =====");
    long t = System.currentTimeMillis();
    Collections.sort(documents, new DocSeqComparator());
    long tt = System.currentTimeMillis() - t;
    //documents.stream().forEach( d -> out.println(d.getSequenceString()));
    out.println("Sort took: "+tt+"ms");
  }

}
