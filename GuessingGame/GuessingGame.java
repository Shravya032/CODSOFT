import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
private static final int START_RANGE = 1;
private static final int END_RANGE = 100;
private static final int MAX_TRIES = 7;

public static void main(String[] args) {
Scanner inputScanner = new Scanner(System.in);
Random randomGenerator = new Random();
int victories = 0;
int totalGames = 0;

System.out.println("Number game:Guessing a number");

while (true) {
int secretNumber = generateRandomNumber(randomGenerator, START_RANGE, END_RANGE);
boolean guessedcrct = conductGameRound(inputScanner, secretNumber, MAX_TRIES);

if (guessedcrct) {
victories++;
System.out.println("Well done! You've guessed the number right!");
} else {
System.out.println("You've exhausted all attempts. The correct number was " + secretNumber + ". Try again next time.");
}

totalGames++;
System.out.println("Score: " + victories + " victory/ies out of " + totalGames);

if (!PlayAgain(inputScanner)) {
break;
}
}

System.out.println("Game over. Final score: " + victories + "/" + totalGames);
inputScanner.close();
}

private static int generateRandomNumber(Random randomGenerator, int lower, int upper) {
return randomGenerator.nextInt(upper - lower + 1) + lower;
}

private static boolean conductGameRound(Scanner inputScanner, int secret, int attempts) {
System.out.println("Alright, choose a number from 1 to 100!");
for (int attempt = 0; attempt < attempts; attempt++) {
System.out.print("Your guess: ");
int guess;
try {
guess = inputScanner.nextInt();
} catch (Exception e) {
System.out.println("Only numbers! That didn't count as a valid attempt.");
inputScanner.next(); // clear erroneous input
attempt--;
continue;
}

if (guess == secret) {
return true;
} else if (guess > secret) {
System.out.println("Too high, give it another shot.");
} else {
System.out.println("Too low, try once more.");
}

System.out.println("Attempts remaining: " + (attempts - attempt - 1));
}
return false;
}

private static boolean PlayAgain(Scanner inputScanner) {
System.out.print("Wish to play again? (yes/no): ");
return inputScanner.next().trim().toLowerCase().equals("yes");
}
}