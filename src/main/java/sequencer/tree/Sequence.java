package sequencer.tree;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

  private int[] sequenceValues;
  private String sequenceString;

  public Sequence(int[] sequenceValues, String sequenceString) {
    this.sequenceValues = sequenceValues;
    this.sequenceString = sequenceString;
  }

  public Sequence(int level) {
    this.sequenceValues = new int[level];
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
