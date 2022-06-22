package sequencer.tree;

import org.junit.jupiter.api.Test;
import sequencer.Document;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TreeDocumentBuilderTest extends AbstractDocumentTest {

  @Test
  public void shouldCreateTreeFromListOfDocuments(){

    List<Document> documents = getDocuments();

    Node root = TreeDocumentBuilder.build(documents);

    assertNotNull(root);

  }

}
