package sequencer.tree;

import sequencer.entity.Document;

import java.util.ArrayList;
import java.util.List;

public class SequenceBuilder {

  private static final int DEEPEST_LEVEL = 200;

  public static List<Sequence> getSequence(Node<Document> root) {
    Sequencer sequencer = new Sequencer(DEEPEST_LEVEL);
    List<Sequence> sequences = new ArrayList<>();
    for (Node<Document> node : root.getChildNodes()) {
      addSequence(sequences, sequencer, node);
    }

    return sequences;
  }

  private static void addSequence(List<Sequence> sequences, Sequencer sequencer, Node<Document> node) {
    if (!node.get().isActive()) return;
    if (sequencer.getLevel() > node.getLevel()) {
      sequencer.cleanSequence(node.getLevel());
    }
    sequencer.increaseLevel(node.getLevel() - 1);
    sequences.add(sequencer.getSequence());
    node.setSequence(sequencer.getSequence());
    if (node.getChildCount() > 0) {
      node.getChildNodes().stream().forEach(child -> addSequence(sequences, sequencer, child));
    }
  }

}
