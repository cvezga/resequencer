package sequencer.tree;

import org.junit.jupiter.api.Test;

import sequencer.DocumentSequencer;
import sequencer.entity.Document;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteDocumentTest extends AbstractDocumentTest {

  @Test
  public void shouldSequenceDocumentsAfterDeletions() {

    List<Document> originalDocuments = getDocuments();

    List<Integer> docsIdToInactivate = Arrays.asList(30, 130, 180, 210);

    originalDocuments.stream()
            .filter(doc -> docsIdToInactivate.contains(doc.getId()))
            .forEach(doc -> doc.setActive(false));


    long count = originalDocuments.stream().filter(doc -> !doc.isActive()).count();

    assertEquals(4, count);

    List<Document> sequencedDocuments = DocumentSequencer.sequence(originalDocuments);

    List<Document> expectedDocumentsAfterSequenced = getExpectedDocumentsAfterSequenced();

    assertEquals(expectedDocumentsAfterSequenced.size(), sequencedDocuments.size());

    for (int i = 0; i < expectedDocumentsAfterSequenced.size(); i++) {
      Document d1 = expectedDocumentsAfterSequenced.get(i);
      Document d2 = sequencedDocuments.get(i);
      assertEquals(d1.getId(), d2.getId());
      assertEquals(d1.getOrder(), d2.getOrder());
      assertEquals(d1.getSequence(), d2.getSequence());
      assertEquals(d1.isActive(), d2.isActive());
    }

  }

}
