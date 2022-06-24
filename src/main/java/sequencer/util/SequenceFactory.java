package sequencer.util;

import sequencer.tree.Sequence;

public class SequenceFactory {

  private final int[] values = new int[200];

  public Sequence getInstance(String stringSequence) {
    char[] chars = stringSequence.toCharArray();
    int idx = 0;
    int ptr = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '.') {
        values[idx++] = Integer.valueOf(stringSequence.substring(ptr, i));
        ptr = i + 1;
      }
    }
    values[idx] = Integer.valueOf(stringSequence.substring(ptr));

    int[] levels = new int[idx + 1];
    System.arraycopy(values, 0, levels, 0, idx + 1);

    return new Sequence(levels, stringSequence);

  }

}
