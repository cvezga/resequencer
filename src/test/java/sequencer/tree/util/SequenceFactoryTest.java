package sequencer.tree.util;

import org.junit.jupiter.api.Test;
import sequencer.tree.Sequence;
import sequencer.util.SequenceFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequenceFactoryTest {

  @Test
  public void shouldCreateSequenceFromString() {
    SequenceFactory f = new SequenceFactory();

    Sequence sequence = f.getInstance("1.2.3.4.5");

    assertEquals("1.2.3.4.5", sequence.getSequenceString());
    assertEquals(5, sequence.getLevel());
    assertEquals(1, sequence.getLevelValue(0));
    assertEquals(2, sequence.getLevelValue(1));
    assertEquals(3, sequence.getLevelValue(2));
    assertEquals(4, sequence.getLevelValue(3));
    assertEquals(5, sequence.getLevelValue(4));
  }
}
