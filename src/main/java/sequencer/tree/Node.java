package sequencer.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

  private T t;
  private Sequence sequence;
  private Node parent;
  private List<Node<T>> children;

  public Node(Sequence sequence, T t) {
    this.sequence = sequence;
    this.t = t;
  }

  public void addChild(Node<T> node) {
    if (children == null) {
      children = new ArrayList<>();
    }
    node.setParent(this);
    children.add(node);
  }

  private void setParent(Node<T> parent) {
    this.parent = parent;
  }

  public int getChildCount() {
    if (this.children == null) return 0;
    return this.children.size();
  }

  public List<Node<T>> getChildNodes() {
    return this.children;
  }

  public int getLevel() {
    return this.sequence.getLevel();
  }

  public Sequence getSequence() {
    return sequence;
  }

  public T get() {
    return this.t;
  }

  public void setSequence(Sequence sequence) {
    this.sequence = sequence;
  }
}
