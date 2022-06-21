package sequencer.tree;

import sequencer.DocSeqComparator;
import sequencer.Document;
import sequencer.Sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TreeDocumentBuilder {

  private static final int DEEPEST_LEVEL = 10;

  public static Node build(List<Document> documents) {
    Node root = new Node(0, null);

    //Sort documents by its sequence
    Collections.sort(documents, new DocSeqComparator());

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    for (Document doc : documents) {
      while (!stack.isEmpty() && stack.peek().getLevel() >= doc.getSequence().getLevel()) {
        stack.pop();
      }


      //If same level, then add as child to the node at top of the stack
      if (stack.peek().getLevel() == doc.getSequence().getLevel()) {
        stack.peek().addChild(new Node(doc.getSequence().getLevel(), doc));
      } else if (stack.peek().getLevel() < doc.getSequence().getLevel()) {
        Node node = new Node(doc.getSequence().getLevel(), doc);
        stack.peek().addChild(node);
        stack.push(node);
      }

    }

    return root;
  }


}
