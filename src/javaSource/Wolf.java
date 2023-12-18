package javaSource;

import java.util.Random;

public class Wolf extends Animal {
    public Wolf() {
        //super("Wolf", 10, 0, 0);
        super("Wolf");
        this.health = 20;
    }

    /*public void move() {
        Random rand = new Random();
        this.x = rand.nextInt(10);
        this.y = rand.nextInt(10);
    }*/

    public void attack(Animal other) {
        Random random = new Random();
        if (random.nextBoolean()) {
            System.out.println("Attack successful!");
            this.health += 3;
            other.reduceHealth(5);
        } else {
            System.out.println("Attack missed!");
        }
    }
    public void move(String direction) {
        int deltaX = 0;
        int deltaY = 0;

        // Determine the movement based on the provided direction
        switch (direction.toLowerCase()) {
            case "up":
                deltaY = -1;
                break;
            case "down":
                deltaY = 1;
                break;
            case "left":
                deltaX = -1;
                break;
            case "right":
                deltaX = 1;
                break;
            default:
                System.out.println("Invalid direction. Wolf stays in place.");
        }

        // Update the wolf's position
        this.x += deltaX;
        this.y += deltaY;

        // Ensure the wolf stays within the boundaries of the game world (adjust as needed)
        this.x = Math.max(0, Math.min(this.x, 9));  // Assuming a 10x10 grid
        this.y = Math.max(0, Math.min(this.y, 9));
    }

}
