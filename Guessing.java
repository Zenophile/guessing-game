import java.util.Random;
import java.util.Scanner;

public class Guessing {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
a
        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!\n"
                + "I'm thinking of a Number between 1 and 100.\n"
                + "Please select the difficulty level:\n"
                + "1. Easy (10 chances)\n"
                + "2. Medium (5 chances)\n"
                + "3. Hard (3 chances)\n");

            System.out.print("Select the difficulty: ");
            
            int choice = scanner.nextInt();
            int tries = 0;
            boolean validChoice = false;
            
            while (!validChoice) {
                if (choice == 1) {
                    System.out.println("\nEasy mode selected.");
                    tries = 10;
                    validChoice = true;
                } else if (choice == 2) {
                    tries = 5;
                    System.out.println("\nMedium mode selected.");
                    validChoice = true;
                } else if (choice == 3) {
                    tries = 3;
                    System.out.println("\nHard mode selected.");
                    validChoice = true;
                } else {
                    System.out.println("\nInvalid choice. Please select a valid difficulty level.");
                    System.out.print("Select the difficulty: ");
                    choice = scanner.nextInt();
                }
            }

            Random random = new Random();
            int attempt = 0;
            int gameover = tries;
            int randomNumber = random.nextInt(100) + 1;
            boolean gameWon = false;

            for (int i = 1; i <= tries; i++) {
                System.out.print("Guess the number: ");
                int guess = scanner.nextInt();
                attempt++;
                gameover--;

                if (guess == randomNumber) {
                    System.out.println("Congratulations, you won!\n"
                    + "You guessed the number in " + attempt + " attempts.\n\n"
                    + "Press 1 to play again or 2 to exit the game.\n");
                    int retry = scanner.nextInt();
                    if (retry == 1) {
                        System.out.println("Restarting match.");
                        break;
                    } else if (retry == 2) {
                        System.out.println("Goodbye");
                        playAgain = false;
                        break;
                    }
                    gameWon = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }

                if (gameover == 0) {
                    System.out.println("Game Over, the random number was: " + randomNumber + "\n\n"
                    + "Press 1 to play again or 2 to exit the game.\n");
                    int retry = scanner.nextInt();
                    if (retry == 1) {
                        System.out.println("Restarting match.");
                        break;
                    } else if (retry == 2) {
                        System.out.println("Goodbye");
                        playAgain = false;
                        break;
                    }
                }
            }

            if (!gameWon) {
                System.out.println("The random number was: " + randomNumber);
            }
        }

        scanner.close();
    }
}
