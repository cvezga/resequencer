package sequencer.tree;

import sequencer.Sequence;
import sequencer.Sequencer;

import java.util.ArrayList;
import java.util.List;

public class SequenceBuilder {

  private static final int DEEPEST_LEVEL = 200;

  public static List<Sequence> getSequence(Node root) {
    Sequencer sequencer = new Sequencer(DEEPEST_LEVEL);
    List<Sequence> sequences = new ArrayList<>();
    for (Node node : root.getChildNodes()) {
      addSequence(sequences, sequencer, node);
    }

    return sequences;
  }

  private static void addSequence(List<Sequence> sequences, Sequencer sequencer, Node node) {
    if (!node.getDocument().isActive()) return;
    if (sequencer.getLevel() > node.getLevel()) {
      sequencer.cleanSequence(node.getLevel());
    }
    sequencer.increaseLevel(node.getLevel() - 1);
    sequences.add(sequencer.getSequence());
    if (node.getChildCount() > 0) {
      node.getChildNodes().stream().forEach(child -> addSequence(sequences, sequencer, child));
    }
  }

}
