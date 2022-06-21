package sequencer.tree;

import sequencer.Sequence;

import java.util.ArrayList;
import java.util.List;

public class SequenceBuilder {

  private static final int DEEPEST_LEVEL = 10;

  public static List<Sequence> getSequence(Node root){
    int[] sequenceIndex = new int[DEEPEST_LEVEL];
    List<Sequence> sequences = new ArrayList<>();
    for(Node node : root.getChildNodes()){
      addSequence(sequences, sequenceIndex, node);
    }

    return sequences;
  }

  private static void addSequence(List<Sequence> sequences, int[] sequenceIndex, Node node) {
    if(!node.getDocument().isActive()) return;
    if(sequenceIndex[node.getLevel()]>0){
      cleanSequenceIndex(sequenceIndex,node.getLevel());
    }
    sequenceIndex[node.getLevel()-1]++;
    sequences.add(new Sequence(sequenceIndex));
    if(node.getChildCount()>0){
      node.getChildNodes().stream().forEach( child -> addSequence(sequences, sequenceIndex, child));
    }
  }

  private static void cleanSequenceIndex(int[] sequenceIndex, int level) {
    while(level<sequenceIndex.length && sequenceIndex[level]>0){
      sequenceIndex[level++]=0;
    }
  }

}
