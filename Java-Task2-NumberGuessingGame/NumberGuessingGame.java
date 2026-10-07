import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 7;
        int round = 0;
        int roundsWon = 0;
        String playAgain;

        System.out.println("=== Number Guessing Game ===");

        do {
            round++;
            int number = random.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            boolean won = false;

            System.out.println("\nRound " + round + ": I picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + " of " + maxAttempts + " - Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct!");
                    won = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            }

            if (won) {
                roundsWon++;
                System.out.println("Round " + round + " - guessed in " + attempts + " attempts");
            } else {
                System.out.println("You Lost! The number was " + number);
            }

            System.out.print("Play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\nGame Over! You won " + roundsWon + " out of " + round + " rounds.");
        sc.close();
    }
}
