package sequencer;

public class Document {

  private int id;
  private boolean active;
  private Sequence sequence;

  public Document(int id) {
    this.id = id;
    this.active = true;
  }

  public int getId() {
    return id;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setSequence(Sequence sequence) {
    this.sequence = sequence;
  }

  public String getSequenceString() {
    return this.sequence.getSequenceString();
  }

  public Sequence getSequence() {
    return this.sequence;
  }

  @Override
  public String toString() {
    return this.sequence.getSequenceString()+": level="+this.sequence.getLevel()+", id="+this.id+", active="+this.active;
  }
}
