package sequencer.tree;

public class Sequencer {

  private int[] sequenceValues;
  private int idx;

  public Sequencer(int maxLevel) {
    this.sequenceValues = new int[maxLevel];
    this.idx = 0;
  }

  public Sequence getSequence() {
    int[] level = new int[this.idx + 1];
    System.arraycopy(this.sequenceValues, 0, level, 0, this.idx + 1);
    Sequence sequence = new Sequence(level, buildSequenceString(level));
    return sequence;
  }

  private String buildSequenceString(int[] values) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
      if (sb.length() > 0) sb.append(".");
      sb.append(values[i]);
    }
    return sb.toString();
  }


  public int getValue(int level) {
    return this.sequenceValues[level];
  }

  public void cleanSequence(int level) {
    while (level < this.sequenceValues.length && this.sequenceValues[level] > 0) {
      this.sequenceValues[level++] = 0;
    }
  }

  public void increaseLevel(int idx) {
    this.idx = idx;
    this.sequenceValues[this.idx]++;
  }

  public int getLevel() {
    return this.idx + 1;
  }
}
