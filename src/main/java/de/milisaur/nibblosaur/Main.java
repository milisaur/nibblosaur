package de.milisaur.tamagotchi;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Dino dino = new Dino("Heinrich");

    System.out.println("Your dinosaur has hatched!");

    boolean running = true;

    while (running) {
      System.out.println();
      System.out.println("=== DINO TAMAGOTCHI ===");
      System.out.println("[1] Feed");
      System.out.println("[2] Play");
      System.out.println("[3] Sleep");
      System.out.println("[4] Show status");
      System.out.println("[0] Exit");
      System.out.println("Your choice: ");

      String choice = scanner.nextLine();

      switch (choice) {
        case "1" ->
          dino.feed();
        case "2" -> {
          DinoAnimation.play();
          dino.play();
        }
        case "3" ->
          dino.sleep();
        case "4" ->
          dino.showStatus();
        case "0" -> {
          System.out.println("Goodbye! See you soon!");
          running = false;
        }
        default ->
          System.out.println("Invalid choice! Please try again.");
      }

      if (!choice.equals("0")) {
        System.out.println();
        System.out.println(dino.getReaction());
      }
    }

    scanner.close();
  }
}
