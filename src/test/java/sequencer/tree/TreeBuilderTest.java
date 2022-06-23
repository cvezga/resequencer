package sequencer.tree;

import org.junit.jupiter.api.Test;
import sequencer.entity.Document;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TreeBuilderTest extends AbstractDocumentTest {

  @Test
  public void shouldCreateTreeFromListOfDocuments() {

    List<Document> documents = getDocuments();

    Node root = new TreeBuilder<Document>().build(documents, (doc) -> doc.getSequence());

    assertNotNull(root);

  }

}
