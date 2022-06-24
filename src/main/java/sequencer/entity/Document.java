package sequencer.entity;

public class Document {

  private int id;
  private int order;
  private String sequence;
  private boolean active;

  public Document(int id) {
    this.id = id;
    this.active = true;
  }

  public int getId() {
    return id;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getSequence() {
    return sequence;
  }

  public void setSequence(String sequence) {
    this.sequence = sequence;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "Document{" +
            "id=" + id +
            ", order=" + order +
            ", sequence='" + sequence + '\'' +
            ", active=" + active +
            '}';
  }
}
