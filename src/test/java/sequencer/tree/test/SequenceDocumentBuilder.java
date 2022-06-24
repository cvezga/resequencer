package sequencer.tree.test;

import sequencer.entity.Document;
import sequencer.tree.Node;
import sequencer.tree.Sequencer;

import java.util.ArrayList;
import java.util.List;

public class SequenceDocumentBuilder {

  private static final int DEEPEST_LEVEL = 200;

  public static List<Document> getSequencedDocuments(Node<Document> root){
    Sequencer sequencer = new Sequencer(DEEPEST_LEVEL);
    List<Document> documents = new ArrayList<>();
    for(Node<Document> node : root.getChildNodes()){
      addSequence(documents, sequencer, node);
    }

    return documents;
  }

  private static void addSequence(List<Document> documents, Sequencer sequencer, Node<Document> node) {
    if(!node.get().isActive()) return;
    if(sequencer.getValue(node.getLevel())>0){
      sequencer.cleanSequence(node.getLevel());
    }
    sequencer.increaseLevel(node.getLevel()-1);
    Document doc = node.get();
    doc.setSequence(sequencer.getSequence().getSequenceString());
    documents.add(doc);
    if(node.getChildCount()>0){
      node.getChildNodes().stream().forEach( child -> addSequence(documents, sequencer, child));
    }
  }


}