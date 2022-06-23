package sequencer.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class TreeBuilder<T> {

  public Node<T> build(List<T> list, Function<T, String> stringSequenceSupplier) {
    Node root = new Node(new Sequence(null), null);

    List<Node<T>> nodes = new ArrayList<>();
    for (T t : list) {
      String stringSequence = stringSequenceSupplier.apply(t);
      Sequence sequence = new Sequence(stringSequence);
      Node<T> n = new Node(sequence, t);
      nodes.add(n);
    }

    //Sort documents by its sequence
    Collections.sort(nodes, new NodeComparator());

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    for (Node<T> node : nodes) {
      while (!stack.isEmpty() && stack.peek().getLevel() >= node.getSequence().getLevel()) {
        stack.pop();
      }

      stack.peek().addChild(node);

      if (stack.peek().getLevel() < node.getSequence().getLevel()) {
        stack.push(node);
      }
    }

    return root;
  }

}
