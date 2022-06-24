package sequencer;

import sequencer.entity.Document;
import sequencer.tree.Node;
import sequencer.tree.Sequencer;
import sequencer.tree.TreeBuilder;
import sequencer.util.Timer;

import java.util.ArrayList;
import java.util.List;

public class DocumentSequencer {

  private static final int DEEPEST_LEVEL = 200;

  public static List<Document> sequence(List<Document> documents) {

    Timer t = new Timer();

    t.start("Start TreeBuilder");
    Node<Document> root = new TreeBuilder<Document>().build(documents, doc -> doc.getSequence());
    t.end("End TreeBuilder");

    t.start("Start fill sequencedDocuments");
    Sequencer sequencer = new Sequencer(DEEPEST_LEVEL);
    List<Document> sequencedDocuments = new ArrayList<>(documents.size());
    root.getChildNodes().forEach(child -> fill(sequencedDocuments, sequencer, child));
    t.end("End fill sequencedDocuments");

    return sequencedDocuments;
  }

  private static void fill(List<Document> sequencedDocuments, Sequencer sequencer, Node<Document> node) {
    if (!node.get().isActive()) return;
    if (sequencer.getLevel() > node.getLevel()) {
      sequencer.cleanSequence(node.getLevel());
    }
    sequencer.increaseLevel(node.getLevel() - 1);
    Document document = node.get();
    document.setSequence(sequencer.getSequence().getSequenceString());
    sequencedDocuments.add(document);
    if (node.getChildCount() > 0) {
      node.getChildNodes().forEach(child -> fill(sequencedDocuments, sequencer, child));
    }
  }
}
