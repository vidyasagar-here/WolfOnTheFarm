package javaSource;

import java.util.Random;

public class Sheep extends Animal {
    public Sheep() {
        super("Sheep", 10, 0, 0);
    }

    public void bleat(Animal wolf) {
        Random random = new Random();
        if (random.nextBoolean()) {
            System.out.println("Sheep bleats!");
            wolf.moveRandom(); // Move the wolf to a random position
        } else {
            System.out.println("Sheep is silent.");
        }
    }


}
