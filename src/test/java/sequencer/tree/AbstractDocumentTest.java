package sequencer.tree;

import sequencer.entity.Document;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDocumentTest {

  protected List<Document> getDocuments() {
    List<Document> documents = new ArrayList<>();

    documents.add(newDocument(1, "1"));
    documents.add(newDocument(2, "1.1"));
    documents.add(newDocument(3, "1.1.1"));
    documents.add(newDocument(4, "1.1.2"));
    documents.add(newDocument(5, "2"));
    documents.add(newDocument(6, "2.1"));
    documents.add(newDocument(7, "2.1.1"));
    documents.add(newDocument(8, "2.1.2"));
    documents.add(newDocument(9, "2.2"));
    documents.add(newDocument(10, "2.2.1"));
    documents.add(newDocument(11, "2.122"));
    documents.add(newDocument(12, "3"));
    documents.add(newDocument(13, "3.1"));
    documents.add(newDocument(14, "3.1.1"));
    documents.add(newDocument(15, "3.1.2"));

    return documents;
  }

  protected Document newDocument(int id, String stringSequence) {
    Document document = new Document(id);
    document.setSequence(stringSequence);
    return document;
  }

}
