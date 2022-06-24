package sequencer.util;


public class Timer {

  private long time;
  private String text;

  public void start(String text) {
    this.time = System.currentTimeMillis();
    this.text = text;
  }

  public void end() {
    System.out.println(this.text + ": took " + (System.currentTimeMillis() - this.time) + "ms");
  }

}
