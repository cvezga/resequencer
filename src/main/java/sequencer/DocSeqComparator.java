package sequencer;

import java.util.Comparator;

public class DocSeqComparator implements Comparator<Document> {

  @Override
  public int compare(Document s1, Document s2) {
    int level1 = s1.getSequence().getLevel();
    int level2 = s2.getSequence().getLevel();
    int maxLevelToCompare = Math.max(level1, level2) + 1;
    for (int i = 0; i < maxLevelToCompare; i++) {
      int v1 = s1.getSequence().getLevelValue(i);
      int v2 = s2.getSequence().getLevelValue(i);
      if (v1 == v2) {
        continue;
      } else {
        return v1 - v2;
      }
    }
    return 0;
  }

}
