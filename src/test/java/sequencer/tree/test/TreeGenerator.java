package sequencer.tree.test;

import sequencer.entity.Document;
import sequencer.tree.Node;
import sequencer.tree.Sequence;

public class TreeGenerator {

  private int id = 999;

  public Node build(int numberOfParentNodes, int deepLevel, int numberOfLeafNodesPerLevel) {
    Node root = new Node(new Sequence(0), null);

    for (int i = 0; i < numberOfParentNodes; i++) {
      Node node = new Node(new Sequence(1), new Document(nextId()));
      root.addChild(node);
      for (int j = 0; j < deepLevel; j++) {
        addChildren(node, 2, deepLevel, numberOfLeafNodesPerLevel);
      }
    }

    return root;
  }

  private int nextId() {
    return ++this.id;
  }

  private void addChildren(Node node, int level, int deepLevel, int numberOfLeafNodesPerLevel) {
    if (level <= deepLevel) {
      Node child = new Node(new Sequence(level), new Document(nextId()));
      node.addChild(child);
      addChildren(child, level + 1, deepLevel, numberOfLeafNodesPerLevel);
    } else if (node.getChildCount() < numberOfLeafNodesPerLevel) {
      Node child = new Node(new Sequence(level), new Document(nextId()));
      node.addChild(child);
      addChildren(node, level, deepLevel, numberOfLeafNodesPerLevel);
    }
  }
}
