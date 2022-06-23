package sequencer.tree;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

  private int[] sequenceValues;
  private String sequenceString;

  public Sequence(String sequenceString) {
    this.sequenceValues = getSequenceValues(sequenceString);
    this.sequenceString = sequenceString;
  }

  private int[] getSequenceValues(String sequenceString) {
    if (sequenceString == null) return new int[0];
    List<Integer> values = new ArrayList<>();
    int idx = 0;
    while (idx < sequenceString.length()) {
      int idx2 = sequenceString.indexOf(".", idx);
      if (idx2 > -1) {
        String xvalue = sequenceString.substring(idx, idx2);
        values.add(Integer.valueOf(xvalue));
        idx = idx2 + 1;
      } else {
        String xvalue = sequenceString.substring(idx);
        values.add(Integer.valueOf(xvalue));
        break;
      }
    }
    int[] sequenceValues = new int[values.size()];
    for (int i = 0; i < values.size(); i++) {
      sequenceValues[i] = values.get(i).intValue();
    }
    return sequenceValues;
  }

  public Sequence(int[] sequenceValues, String sequenceString) {
    this.sequenceValues = sequenceValues;
    this.sequenceString = sequenceString;
  }

  public String getSequenceString() {
    return this.sequenceString;
  }

  public int getLevel() {
    return this.sequenceValues.length;
  }

  public int getLevelValue(int idx) {
    if (idx > this.sequenceValues.length - 1) return 0;
    return this.sequenceValues[idx];
  }
}
