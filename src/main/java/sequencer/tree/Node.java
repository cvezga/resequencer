package sequencer.tree;

import sequencer.Document;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Document document;
    private int level;
    private Node parent;
    private List<Node> children;

    public Node(int level, Document document){
        this.level = level;
        this.document = document;
    }

    public void addChild(Node node) {
        if(children == null) {
            children = new ArrayList<>();
        }
        node.setParent(this);
        children.add(node);
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public int getChildCount() {
        if(this.children == null) return 0;
        return this.children.size();
    }

    public List<Node> getChildNodes() {
        return this.children;
    }

    public int getLevel() {
        return this.level;
    }

    public Document getDocument() {
        return this.document;
    }
}
