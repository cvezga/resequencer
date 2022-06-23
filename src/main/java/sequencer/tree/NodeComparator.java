package sequencer.tree;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

  @Override
  public int compare(Node n1, Node n2) {
    int level1 = n1.getLevel();
    int level2 = n2.getLevel();
    int maxLevelToCompare = Math.max(level1, level2) + 1;
    for (int i = 0; i < maxLevelToCompare; i++) {
      int v1 = n1.getSequence().getLevelValue(i);
      int v2 = n2.getSequence().getLevelValue(i);
      if (v1 == v2) {
        continue;
      } else {
        return v1 - v2;
      }
    }
    return 0;
  }

}
