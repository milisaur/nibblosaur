package de.milisaur.nibblosaur;

import java.util.Random;

public class Dino {
  private String name;
  private int satiety;
  private int happiness;
  private int energy;
  private final Random random = new Random();

  public Dino(String name) {
    this.name = name;
    this.satiety = 50;
    this.happiness = 80;
    this.energy = 70;
  }

  public void feed() {
    satiety = Math.min(100, satiety + 20);
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
    satiety = Math.max(0, satiety - 10);

    System.out.println(name + " is having a great time playing!");
  }

  public void sleep() {
    energy = Math.min(100, energy + 30);
    satiety = Math.max(0, satiety - 5);

    System.out.println(name + " had a good nap and feels refreshed!");
  }

  public void showStatus() {
    System.out.println("Name: " + name);
    System.out.println("Satiety: " + satiety + "/100");
    System.out.println("Happiness: " + happiness + "/100");
    System.out.println("Energy: " + energy + "/100");
    System.out.println("Mood: " + getMood());
  }

  public Mood getMood() {
    if (satiety <= 20) {
      return Mood.HUNGRY;
    }

    if (energy <= 20) {
      return Mood.TIRED;
    }

    if (happiness <= 30) {
      return Mood.BORED;
    }

    return Mood.HAPPY;
  }

  public String getReaction() {
    String[] reactions = switch (getMood()) {
      case HAPPY -> new String[] {
          name + " happily wags his tail!",
          name + " jumps around excitedly!",
          name + " lets out a cheerful roar!"
      };

      case HUNGRY -> new String[] {
          name + " looks around for food.",
          name + "'s stomach is growling!",
          name + " desperately wants a snack!"
      };

      case TIRED -> new String[] {
          name + " lets out a sleepy yawn.",
          name + " can barely keep his eyes open.",
          name + " curls up and closes his eyes."
      };

      case BORED -> new String[] {
          name + " stares at you impatiently.",
          name + " starts chasing his own tail.",
          name + " looks for something interesting."
      };
    };

    int index = random.nextInt(reactions.length);
    return reactions[index];
  }

  public int getSatiety() {
    return satiety;
  }

  public int getHappiness() {
    return happiness;
  }

  public int getEnergy() {
    return energy;
  }

}
