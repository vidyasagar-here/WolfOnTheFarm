package javaSource;

import java.util.Random;

public class Donkey extends Animal {
    public Donkey() {
        super("Donkey", 10, 0, 0);
    }

    public void kick(Animal other) {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            other.health--;
        }
    }

}
