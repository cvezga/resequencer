package sequencer.tree;

import sequencer.entity.Document;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDocumentTest {

  protected List<Document> getDocuments() {
    List<Document> documents = new ArrayList<>();

    documents.add(newDocument(10, 1, "1"));
    documents.add(newDocument(20, 2, "1.1"));
    documents.add(newDocument(30, 3, "1.1.1"));//to be deleted
    documents.add(newDocument(40, 4, "1.1.2"));
    documents.add(newDocument(50, 5, "1.1.3"));
    documents.add(newDocument(60, 6, "1.2"));
    documents.add(newDocument(70, 7, "1.2.1"));
    documents.add(newDocument(80, 8, "1.2.2"));

    documents.add(newDocument(90, 9, "2"));
    documents.add(newDocument(100, 10, "2.1"));
    documents.add(newDocument(110, 11, "2.1.1"));
    documents.add(newDocument(120, 12, "2.1.2"));
    documents.add(newDocument(130, 13, "2.2")); //to be deleted
    documents.add(newDocument(140, 14, "2.2.1"));//*to be deleted by parent
    documents.add(newDocument(150, 15, "2.2.2"));//*to be deleted by parent

    documents.add(newDocument(160, 16, "3"));
    documents.add(newDocument(170, 17, "3.1"));
    documents.add(newDocument(180, 18, "3.1.1"));//to be deleted
    documents.add(newDocument(190, 19, "3.1.2"));
    documents.add(newDocument(200, 20, "3.2"));
    documents.add(newDocument(210, 21, "3.2.1"));//to be deleted
    documents.add(newDocument(220, 22, "3.2.2"));

    return documents;
  }

  protected List<Document> getExpectedDocumentsAfterSequenced() {
    List<Document> documents = new ArrayList<>();

    documents.add(newDocument(10, 1, "1"));
    documents.add(newDocument(20, 2, "1.1"));
    documents.add(newDocument(40, 4, "1.1.1"));
    documents.add(newDocument(50, 5, "1.1.2"));
    documents.add(newDocument(60, 6, "1.2"));
    documents.add(newDocument(70, 7, "1.2.1"));
    documents.add(newDocument(80, 8, "1.2.2"));

    documents.add(newDocument(90, 9, "2"));
    documents.add(newDocument(100, 10, "2.1"));
    documents.add(newDocument(110, 11, "2.1.1"));
    documents.add(newDocument(120, 12, "2.1.2"));

    documents.add(newDocument(160, 16, "3"));
    documents.add(newDocument(170, 17, "3.1"));
    documents.add(newDocument(190, 19, "3.1.1"));
    documents.add(newDocument(200, 20, "3.2"));
    documents.add(newDocument(220, 22, "3.2.1"));

    return documents;
  }

  protected Document newDocument(int id, int order, String stringSequence) {
    Document document = new Document(id);
    document.setOrder(order);
    document.setSequence(stringSequence);
    document.setActive(true);

    return document;
  }

}
