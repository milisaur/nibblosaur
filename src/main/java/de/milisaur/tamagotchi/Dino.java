package de.milisaur.tamagotchi;

public class Dino {
  private String name;
  private int hunger;
  private int happiness;
  private int energy;

  public Dino(String name) {
    this.name = name;
    this.hunger = 50;
    this.happiness = 80;
    this.energy = 70;
  }

  public void feed() {
    hunger = Math.max(0, hunger - 20);
    happiness = Math.min(100, happiness + 5);

    System.out.println(name + " happily eats the food!");
  }

  public void play() {
    if (energy < 20) {
      System.out.println(name + " is too tired to play!");
      return;
    }

    energy = Math.max(0, energy - 20);
    happiness = Math.min(100, happiness + 15);
    hunger = Math.min(100, hunger + 10);

    System.out.println(name + " is having a great time playing!");
  }

  public void sleep() {
    energy = Math.min(100, energy + 30);
    hunger = Math.min(100, hunger + 5);

    System.out.println(name + " had a good nap and feels refreshed!");
  }

  public void showStatus() {
    System.out.println("Name: " + name);
    System.out.println("Hunger: " + hunger + "/100");
    System.out.println("Happiness: " + happiness + "/100");
    System.out.println("Energy: " + energy + "/100");
  }
}
