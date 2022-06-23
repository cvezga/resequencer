package sequencer.tree;

import org.junit.jupiter.api.Test;

import sequencer.entity.Document;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteDocumentTest extends AbstractDocumentTest {

  List<Document> documents = getDocuments();

  @Test
  public void shouldDeleteAndSequence() {

    Node root = new TreeBuilder<Document>().build(documents, (doc) -> doc.getSequence());
    assertNotNull(root);

    //Inactivate some documents
    NodeIndex index = new NodeIndex<Document>(root);
    assertEquals(15, index.getValues().size());
    Document doc21 = (Document) index.getNodeByStringSequence("2.1").get();
    Document doc313 = (Document) index.getNodeByStringSequence("3.1.1").get();
    assertNotNull(doc21);
    assertNotNull(doc313);
    doc21.setActive(false);
    doc313.setActive(false);

    //Create new sequence
    SequenceBuilder.getSequence(root);

    NodeIndex index2 = new NodeIndex<Document>(root);

    Collection<Node<Document>> values = index2.getValues();


    Set<Integer> set = values.stream().map(node -> node.get().getId()).collect(Collectors.toSet());
    assertEquals(12, set.size());

    assertFalse(set.contains(doc21.getId()));
    assertFalse(set.contains(doc313.getId()));

  }

}
