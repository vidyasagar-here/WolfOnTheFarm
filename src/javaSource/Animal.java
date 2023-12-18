package javaSource;

import java.util.Random;

public class Animal {
    String species;
    int health;
    int x, y;
    private static int totalAnimals = 0;

    public Animal() {
        this.species = "";
        this.health = 10;
        this.x = 0;
        this.y = 0;
        totalAnimals++;
    }

    public Animal(String species, int health, int x, int y) {
        this.species = species;
        this.health = health;
        this.x = x;
        this.y = y;
        totalAnimals++;
    }

    public Animal(String species) {
        this.species = species;
        this.health = 10;
        this.x = 0;
        this.y = 0;
        totalAnimals++;
    }

    public void move() {
        Random rand = new Random();
        this.x = rand.nextInt(10);
        this.y = rand.nextInt(10);
        this.health--;
    }

    public void moveRandom() {
        Random random = new Random();

        // Generate random deltaX and deltaY values for movement
        int deltaX = random.nextInt(3) - 1;  // Values -1, 0, or 1
        int deltaY = random.nextInt(3) - 1;

        // Update the sheep's position
        this.x += deltaX;
        this.y += deltaY;

        // Ensure the sheep stays within the boundaries of the game world (adjust as needed)
        this.x = Math.max(0, Math.min(this.x, 9));  // Assuming a 10x10 grid
        this.y = Math.max(0, Math.min(this.y, 9));
    }

    public void reduceHealth(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void eat() {
        this.health++;
    }

    public String toString() {
        return "Species: " + this.species + ", Health: " + this.health + ", Position: (" + this.x + ", " + this.y + ")";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!this.species.equals(other.species)) {
            return false;
        }
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }
}
