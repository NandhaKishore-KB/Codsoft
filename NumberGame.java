import java.util.Scanner;

public class NumberGame {
    
    public static void main(String[] args) {
        int totalScore = 0;
        boolean playAgain = true;

        try (Scanner sc = new Scanner(System.in)) {

        while (playAgain) {
            int number = (int) (Math.random() * 100) + 1;
            System.out.println("Guess a number between 1 and 100.");
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 10;

            while (guess != number && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;
                
                if (guess < number) {
                    System.out.println("Too low. Try again.");
                } else if (guess > number) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number.");
                    totalScore += (maxAttempts - attempts + 1);
                }
            }

            if (guess != number) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + number + ".");
            }

            System.out.println("Your current score is: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        sc.close();
        }
    }
}
