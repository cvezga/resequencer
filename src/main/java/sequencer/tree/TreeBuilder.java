package sequencer.tree;

import sequencer.Document;

import java.util.Random;

public class TreeBuilder {

  private int id = 999;

  public  Node build(int numberOfParentNodes, int deepLevel, int numberOfLeafNodesPerLevel){
    Node root = new Node(0, null);

    for(int i=0; i<numberOfParentNodes; i++){
      Node node = new Node(1, new Document(nextId()));
      root.addChild(node);
      for(int j=0; j<deepLevel; j++) {
        addChildren(node, 2, deepLevel, numberOfLeafNodesPerLevel);
      }
    }

    return root;
  }

  private int nextId() {
    this.id += 1;
    return this.id;
  }

  private void addChildren(Node node, int level, int deepLevel, int numberOfLeafNodesPerLevel) {
    if(level<=deepLevel){
      Node child = new Node(level, new Document(nextId()));
      node.addChild(child);
      addChildren(child,level+1,deepLevel, numberOfLeafNodesPerLevel);
    } else if(node.getChildCount() < numberOfLeafNodesPerLevel){
      Node child = new Node(level, new Document(nextId()));
      node.addChild(child);
      addChildren(node, level ,deepLevel, numberOfLeafNodesPerLevel);
    }
  }
}
