import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Scanning a dictionary txt file and importing the words into an arraylist
        File dictionary = new File("src/dictionary.txt");

        Scanner dictScanner = new Scanner(dictionary);

        List<String> words = new ArrayList<>();
        while (dictScanner.hasNextLine()) {
            words.add(dictScanner.nextLine());
        }

        // Picking a random word from the list
        String wordToGuess = words.get((int) (Math.random() * words.size()));
//        System.out.println(wordToGuess);

        // Printing dashes to represent randomly chosen word
        List<Character> playerGuesses = new ArrayList<>();

        // Asking player input and continually checking game state
        Scanner input = new Scanner(System.in);
        int wrongCount = 0;

        while (true) {

            printHangedMan(wrongCount);

            if (wrongCount == 10) {
                System.out.println("Game Over!");
                break;
            }

            printCurrentWordProgress(wordToGuess, playerGuesses);
            if (!getPlayerGuess(input, wordToGuess, playerGuesses)) {
                wrongCount++;
            }

            if (printCurrentWordProgress(wordToGuess, playerGuesses)) {
                System.out.println("You Win!");
                break;
            }

            System.out.println("Enter your guess for the word:");
            if (input.nextLine().equals(wordToGuess)) {
                System.out.println("You win!");
                break;
            } else {
                System.out.println("Incorrect, try again.");
            }
        }



    }

    public static boolean printCurrentWordProgress(String wordToGuess, List<Character> playerGuesses) {
        int correctCount = 0;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (playerGuesses.contains(wordToGuess.charAt(i))) {
                System.out.print(Character.toUpperCase(wordToGuess.charAt(i)));
                correctCount++;
            } else {
                System.out.print("_");
            }
        }

        System.out.println();

        System.out.print("All letters guessed: ");

        for (char guesses: playerGuesses) {
            System.out.print(Character.toUpperCase(guesses));
        }

        System.out.println();

        return (wordToGuess.length() == correctCount);
    }

    public static boolean getPlayerGuess(Scanner input,String wordToGuess, List<Character> playerGuesses) {
        System.out.println("Enter a letter:");

        String guess = input.nextLine();

        while (guess.length() != 1) {
            System.out.println("Cannot enter more or less than one letter:");
            guess = input.nextLine();
        }

        playerGuesses.add(guess.charAt(0));

        return wordToGuess.contains(guess);
    }

    public static void printHangedMan(int wrongCount) {
        switch (wrongCount) {
            case 0: System.out.println("""
                        --------
                        |      |""");
                break;
            case 1: System.out.println("""
                        --------
                        |      |
                        O""");
                break;
            case 2: System.out.println("""
                         --------
                         |      |
                         O
                        \\""");
                break;
            case 3: System.out.println("""
                          --------
                          |      |
                        \\ O
                         \\""");
                break;
            case 4: System.out.println("""
                          --------
                          |      |
                        \\ O
                         \\ /""");
                break;
            case 5: System.out.println("""
                          --------
                          |      |
                        \\ O /
                         \\ /""");
                break;
            case 6: System.out.println("""
                          --------
                          |      |
                        \\ O /
                         \\ /
                          |""");
                break;
            case 7: System.out.println("""
                          --------
                          |      |
                        \\ O /
                         \\ /
                          |
                         /""");
                break;
            case 8: System.out.println("""
                          --------
                          |      |
                        \\ O /
                         \\ /
                          |
                         /
                        /""");
                break;
            case 9: System.out.println("""
                          --------
                          |      |
                        \\ O /
                         \\ /
                          |
                         / \\
                        /""");
                break;
            case 10: System.out.println("""
                          --------
                          |      |
                        \\ O /
                         \\ /
                          |
                         / \\
                        /   \\""");
                break;
        }
    }
}
