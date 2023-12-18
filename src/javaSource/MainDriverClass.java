package javaSource;

import java.util.Scanner;

public class MainDriverClass {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        Sheep sheep = new Sheep();
        Donkey donkey = new Donkey();

        System.out.println("Total number of animals: " + Animal.getTotalAnimals());

        System.out.println("Welcome to the farm! You are a wolf inside a pen with a sheep and a donkey.");

        Scanner scanner = new Scanner(System.in);

        while (wolf.health > 0 && (sheep.health > 0 || donkey.health > 0)) {

            // Get user input for the wolf's choice
            System.out.println("Choose your action:");
            System.out.println("1. Move (Up/Down/Left/Right)");
            System.out.println("2. Attack");
            System.out.println("3. Check Animal Status");

            String action = scanner.next();

            switch (action) {
                case "1":
                    System.out.println("Enter direction (Up/Down/Left/Right):");
                    String direction = scanner.next();
                    wolf.move(direction);
                    break;
                case "2":
                    System.out.println("Choose the target animal (Sheep/Donkey):");
                    String targetAnimal = scanner.next();
                    Animal target = (targetAnimal.equalsIgnoreCase("Sheep")) ? sheep : donkey;
                    wolf.attack(target);
                    /*System.out.println("Choose a target: Sheep or Donkey");
                    String target = scanner.nextLine();
                    if (target.equalsIgnoreCase("Sheep")) {
                        donkey.kick(sheep);
                    } else if (target.equalsIgnoreCase("Donkey")) {
                        sheep.bleat();
                    } else {
                        System.out.println("Invalid target. Try again.");
                    }*/
                    break;
                case "3":
                    System.out.println("Wolf: " + wolf.toString());
                    System.out.println("Sheep: " + sheep.toString());
                    System.out.println("Donkey: " + donkey.toString());
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

            if (wolf.health == 0 || (sheep.health == 0 && donkey.health == 0)) {
                break;
            }

            /*sheep.move();
            donkey.move();*/
            donkey.moveRandom();
            sheep.moveRandom();

            donkey.kick(wolf);

            sheep.bleat(wolf);

            // Wolf will loses one health point after each round
            wolf.reduceHealth(1);

            if (wolf.health == 0 || (sheep.health == 0 && donkey.health == 0)) {
                break;
            }

        }
        scanner.close();
        System.out.println("Game Over!");
    }
}