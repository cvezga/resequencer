package sequencer.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeIndex<T> {

  private Map<String, Node<T>> nodeMap = new HashMap<>();

  public NodeIndex(Node root) {

    List<Node> nodes = new ArrayList<>();

    updateNodeList(nodes, root);

    nodes.stream().forEach(node -> {
      this.nodeMap.put(node.getSequence().getSequenceString(), node);
    });

  }

  private void updateNodeList(List<Node> nodes, Node<T> root) {
    if (root.getChildCount() > 0) {
      nodes.addAll(root.getChildNodes());
      root.getChildNodes().stream().forEach(child -> updateNodeList(nodes, child));
    }
  }


  public Node<T> getNodeByStringSequence(String stringSequence) {
    return this.nodeMap.get(stringSequence);
  }

  public Collection<Node<T>> getValues() {
    return this.nodeMap.values();
  }
}
