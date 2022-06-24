package sequencer.util;


public class Timer {

  private long time;

  public void start(String text) {
    this.time = System.currentTimeMillis();
    System.out.println(text);
  }

  public void end(String text) {
    System.out.println(text + " - took " + (System.currentTimeMillis() - this.time) + "ms");
  }

}
