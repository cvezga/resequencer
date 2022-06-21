package sequencer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentIndex {

  private Map<Integer,Document> documentMap = new HashMap<>();
  private Map<String,Document> levelKeyMap = new HashMap<>();

  public DocumentIndex(List<Document> documents){
    documents.stream().forEach( doc -> {
      this.documentMap.put(doc.getId(), doc);
      this.levelKeyMap.put(doc.getSequenceString(), doc);
    });

  }

  public Document getDocumentById(int id){
    return this.documentMap.get(id);
  }

  public Document getDocumentByLevelKey(String levelKey){
    return this.levelKeyMap.get(levelKey);
  }

}
