import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {

    // Method to play one round of the game
    public static void playRound(int maxAttempts, int lowerBound, int upperBound) {
        Random rand = new Random();
        int targetNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        boolean correctGuess = false;
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);
        
        // Allow user to guess multiple times, up to maxAttempts
        while (attempts < maxAttempts && !correctGuess) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                correctGuess = true;
                System.out.println("Congratulations! You guessed the correct number.");
            } else if (userGuess < targetNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }

            if (attempts == maxAttempts && !correctGuess) {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + targetNumber);
            }
        }
    }

    // Method to calculate and display the score based on attempts
    public static int calculateScore(int maxAttempts, int attemptsTaken) {
        if (attemptsTaken <= maxAttempts) {
            return maxAttempts - attemptsTaken + 1; // Higher score for fewer attempts
        }
        return 0; // No score if the user ran out of attempts
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalRounds = 0;
        int totalScore = 0;
        int maxAttempts = 5; // User has a maximum of 5 attempts per round
        int lowerBound = 1; // Lower bound of the number range
        int upperBound = 100; // Upper bound of the number range

        // Loop for multiple rounds of the game
        boolean playAgain = true;
        while (playAgain) {
            totalRounds++;
            System.out.println("\nRound " + totalRounds);
            
            playRound(maxAttempts, lowerBound, upperBound);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
            }

            // Calculate the score for this round
            int scoreForRound = calculateScore(maxAttempts, maxAttempts); // Assume maximum attempts used
            totalScore += scoreForRound;

            System.out.println("Your score this round: " + scoreForRound);
        }

        // Final score after all rounds
        System.out.println("\nGame over. Your total score is: " + totalScore);
        System.out.println("Thank you for playing!");
    }
}