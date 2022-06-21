package sequencer.tree;

import sequencer.Document;
import sequencer.Sequence;

import java.util.ArrayList;
import java.util.List;

public class SequenceDocumentBuilder {

  private static final int DEEPEST_LEVEL = 10;

  public static List<Document> getSequencedDocuments(Node root){
    int[] sequenceIndex = new int[DEEPEST_LEVEL];
    List<Document> documents = new ArrayList<>();
    for(Node node : root.getChildNodes()){
      addSequence(documents, sequenceIndex, node);
    }

    return documents;
  }

  private static void addSequence(List<Document> documents, int[] sequenceIndex, Node node) {
    if(!node.getDocument().isActive()) return;
    if(sequenceIndex[node.getLevel()]>0){
      cleanSequenceIndex(sequenceIndex,node.getLevel());
    }
    sequenceIndex[node.getLevel()-1]++;
    Document doc = node.getDocument();
    doc.setSequence(new Sequence(sequenceIndex));
    documents.add(doc);
    if(node.getChildCount()>0){
      node.getChildNodes().stream().forEach( child -> addSequence(documents, sequenceIndex, child));
    }
  }

  private static void cleanSequenceIndex(int[] sequenceIndex, int level) {
    while(level<sequenceIndex.length && sequenceIndex[level]>0){
      sequenceIndex[level++]=0;
    }
  }

}
