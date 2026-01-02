import java.util.Random;
import java.util.Scanner;

public class Chapter1_Challenge_1_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int health = 100; // Step 1: Player's starting health

        // Step 2: Loop through 5 rooms
        for (int room = 1; room <= 5; room++) {
            System.out.println("\nEntering room " + room + "...");

            int event = rand.nextInt(3) + 1; // Random event: 1-3

            switch (event) {
                case 1: // Trap
                    health -= 20;
                    System.out.println("A trap sprung! Health is now " + health + ".");
                    if (health <= 0) {
                        System.out.println("You have been defeated in room " + room + ".");
                        break; // Exit the switch
                    }
                    break;

                case 2: // Healing potion
                    health += 15;
                    if (health > 100) {
                        health = 100; // Cap health at 100
                    }
                    System.out.println("You found a healing potion! Health is now " + health + ".");
                    break;

                case 3: // Monster
                    int monsterNumber = rand.nextInt(5) + 1; // Monster number 1-5
                    int guess;
                    System.out.println("A monster appears! Guess a number (1-5) to defeat it:");

                    // Step 3: do-while loop for guessing
                    do {
                        guess = input.nextInt();
                        if (guess != monsterNumber) {
                            System.out.print("Wrong! Try again: ");
                        }
                    } while (guess != monsterNumber);

                    System.out.println("You defeated the monster!");
                    break;
            }

            // Check if defeated after trap
            if (health <= 0) {
                break; // Exit the room loop
            }

            // Show current health after each room (optional for monsters)
            if (event != 3) {
                System.out.println("Current health: " + health);
            }
        }

        // Step 7: Announce victory if player survived all rooms
        if (health > 0) {
            System.out.println("\nYou cleared the dungeon! Victorious with " + health + " health!");
        }

        input.close();
    }
}
