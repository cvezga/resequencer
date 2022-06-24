package sequencer.tree;

import sequencer.util.SequenceFactory;
import sequencer.util.Timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class TreeBuilder<T> {

  public Node<T> build(List<T> list, Function<T, String> stringSequenceSupplier) {
    Node<T> root = new Node(new Sequence(0), null);

    SequenceFactory sequenceFactory = new SequenceFactory();

    Timer tm = new Timer();

    tm.start("Node create iterator");
    List<Node<T>> nodes = new ArrayList<>(list.size());
    for (T t : list) {
      String stringSequence = stringSequenceSupplier.apply(t);
      Sequence sequence = sequenceFactory.getInstance(stringSequence);
      Node<T> n = new Node(sequence, t);
      nodes.add(n);
    }
    tm.end();

    //Sort documents by its sequence
    tm.start("Sort Nodes");
    Collections.sort(nodes, new NodeComparator());
    tm.end();

    tm.start("Stack tree build");
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
    tm.end();

    return root;
  }

}
