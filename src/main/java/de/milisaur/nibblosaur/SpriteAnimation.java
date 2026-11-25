package de.milisaur.nibblosaur;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation {

  private static final int FRAME_SIZE = 128;
  private static final int FRAME_COUNT = 12;
  private static final int COLUMNS = 4;

  private final ImageView sprite;
  private final Timeline timeline;

  private int currentFrame = 0;

  public SpriteAnimation(ImageView sprite, int frameDuration) {
    this.sprite = sprite;

    showFrame();

    timeline = new Timeline(
        new KeyFrame(
            Duration.millis(frameDuration),
            event -> {
              currentFrame = (currentFrame + 1) % FRAME_COUNT;
              showFrame();
            }));

    timeline.setCycleCount(Animation.INDEFINITE);
  }

  private void showFrame() {
    int column = currentFrame % COLUMNS;
    int row = currentFrame / COLUMNS;

    sprite.setViewport(new Rectangle2D(
        column * FRAME_SIZE,
        row * FRAME_SIZE,
        FRAME_SIZE,
        FRAME_SIZE));
  }

  public void play() {
    timeline.play();
  }

  public void stop() {
    timeline.stop();
  }
}
