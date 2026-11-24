package de.milisaur.nibblosaur;

public class DinoAnimation {

  private static final int FRAME_DURATION_MS = 5;
  private static final int ANIMATION_CYCLES = 100;
  private static final String[] FRAMES = {
      """
             __
            / _)
           / /
          / /___
          \\_____)
           """,

      """
             __
            / _)
           / /
          / /___
          \\_____)
          """,

      """

             __
            / _)
           / /
          / /___
          \\_____)
           """
  };

  public static void play() {
    for (int cycle = 0; cycle < ANIMATION_CYCLES; cycle++) {
      for (String frame : FRAMES) {
        System.out.print("\033[H\033[2J");
        System.out.print(frame);
        System.out.flush();

        try {
          Thread.sleep(FRAME_DURATION_MS);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }
      }
    }
  }
}
