package sequencer.tree;

import org.junit.jupiter.api.Test;
import sequencer.Document;
import sequencer.Sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TreeDocumentBuilderTest extends DocumentTest {

  @Test
  public void shouldCreateTreeFromListOfDocuments(){

    List<Document> documents = getDocuments();

    Node root = TreeDocumentBuilder.build(documents);

    assertNotNull(root);

  }

}
