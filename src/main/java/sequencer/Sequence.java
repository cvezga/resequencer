package sequencer;

public class Sequence {

  private int[] levels;
  private int level = -1;
  private String sequenceString;

  public Sequence(int[] values){
    this.levels = new int[values.length];
    System.arraycopy(values,0,this.levels, 0, values.length);
  }

  public String getSequenceString() {
    if(this.sequenceString == null){
      this.sequenceString  = buildSequenceString();
    }
    return this.sequenceString;
  }

  public int getLevelValue(int idx){
    return this.levels[idx];
  }

  private String buildSequenceString() {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<levels.length; i++){
      if(levels[i]==0) break;
      if(sb.length()>0) sb.append(".");
      sb.append(levels[i]);
    }
    return sb.toString();
  }


  public int getLevel() {
    if(this.level == -1){
      this.level = updateLevel();
    }
    return this.level;
  }

  private int updateLevel() {
    int level = 0;
    int idx=0;
    while(idx<this.levels.length && this.levels[idx]>0 ){
      level++;
      idx++;
    }
    return level;
  }
}
