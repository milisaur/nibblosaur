package de.milisaur.nibblosaur;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameApp extends Application {

  private final Dino dino = new Dino("Heinrich");

  private ProgressBar satietyBar;
  private ProgressBar happinessBar;
  private ProgressBar energyBar;

  @Override
  public void start(Stage stage) {
    Label title = new Label("NIBBLOSAUR");
    Label message = new Label("Welcome to the jungle!");

    Image spriteSheet = new Image(
        getClass().getResourceAsStream(
            "/assets/characters/heinrich/animations/idle.png"));

    ImageView dinosaur = new ImageView(spriteSheet);

    dinosaur.setFitWidth(256);
    dinosaur.setFitHeight(256);
    dinosaur.setPreserveRatio(true);
    dinosaur.setSmooth(false);

    SpriteAnimation idleAnimation = new SpriteAnimation(dinosaur, 180);

    idleAnimation.play();

    stage.setOnHidden(event -> idleAnimation.stop());

    satietyBar = new ProgressBar();
    happinessBar = new ProgressBar();
    energyBar = new ProgressBar();

    VBox stats = new VBox(
        10,
        new Label("Satiety"),
        satietyBar,
        new Label("Happiness"),
        happinessBar,
        new Label("Energy"),
        energyBar);

    Button feedButton = new Button("Feed");
    Button playButton = new Button("Play");
    Button sleepButton = new Button("Sleep");

    HBox actions = new HBox(
        12,
        feedButton,
        playButton,
        sleepButton);

    actions.setAlignment(Pos.CENTER);

    StackPane center = new StackPane(dinosaur);

    BorderPane root = new BorderPane();

    root.setTop(title);
    root.setCenter(center);

    VBox bottom = new VBox(20, stats, actions);
    bottom.setAlignment(Pos.CENTER);

    root.setBottom(bottom);

    BorderPane.setAlignment(title, Pos.CENTER);

    root.setStyle("-fx-background-color: #12251b;");
    title.setStyle("-fx-text-fill: #a4ddb3; -fx-font-size: 28px;");

    feedButton.setOnAction(event -> {
      dino.feed();
      message.setText(dino.getReaction());
      updateDisplay();
    });

    playButton.setOnAction(event -> {
      dino.play();
      message.setText(dino.getReaction());
      updateDisplay();
    });

    sleepButton.setOnAction(event -> {
      dino.sleep();
      message.setText(dino.getReaction());
      updateDisplay();
    });

    center.getChildren().add(message);

    StackPane.setAlignment(message, Pos.BOTTOM_CENTER);
    message.setStyle("-fx-text-fill: #a4ddb3;");

    Scene scene = new Scene(root, 800, 500);

    stage.setTitle("Nibblosaur");
    stage.setScene(scene);

    updateDisplay();

    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  private void updateDisplay() {
    satietyBar.setProgress(dino.getSatiety() / 100.0);
    happinessBar.setProgress(dino.getHappiness() / 100.0);
    energyBar.setProgress(dino.getEnergy() / 100.0);
  }
}
