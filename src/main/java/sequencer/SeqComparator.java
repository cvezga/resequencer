package sequencer;

import java.util.Comparator;

public class SeqComparator implements Comparator<Sequence> {

  @Override
  public int compare(Sequence s1, Sequence s2) {
    int level1 = s1.getLevel();
    int level2 = s2.getLevel();
    int maxLevelToCompare = Math.max(level1, level2) + 1;
    for (int i = 0; i < maxLevelToCompare; i++) {
      int v1 = s1.getLevelValue(i);
      int v2 = s2.getLevelValue(i);
      if (v1 == v2) {
        continue;
      } else {
        return v1 - v2;
      }
    }
    return 0;
  }

}
