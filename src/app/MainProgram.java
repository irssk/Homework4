package app;

import java.util.Random;
import java.util.Scanner;

public class MainProgram {
    private static final int HINT_LENGTH = 15;

    public static int findSymbolOccurrence(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String expression) {
        return new StringBuilder(expression).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String reversed = stringReverse(str.replaceAll("\\s+", "").toLowerCase());
        return str.replaceAll("\\s+", "").equalsIgnoreCase(reversed);
    }

    public static void guessingGame() {
        String[] words = initializeWords();
        String secretWord = selectRandomWord(words);
        playGame(secretWord);
    }

    private static String[] initializeWords() {
        return new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
    }

    private static String selectRandomWord(String[] words) {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    private static void playGame(String secretWord) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Try to guess the secret word. Type 'exit' to quit.");

        while (true) {
            System.out.print("Your guess: ");
            String userGuess = scanner.nextLine().trim().toLowerCase();

            if (userGuess.equals("exit")) {
                System.out.println("Thanks for playing! The secret word was: " + secretWord);
                break;
            }

            if (userGuess.equals(secretWord)) {
                System.out.println("Congratulations! You guessed the word.");
                break;
            } else {
                System.out.println("Hint: " + generateHint(secretWord, userGuess));
            }
        }
        scanner.close();
    }

    private static String generateHint(String secretWord, String userGuess) {
        StringBuilder hint = new StringBuilder();

        for (int i = 0; i < secretWord.length(); i++) {
            if (i < userGuess.length() && secretWord.charAt(i) == userGuess.charAt(i)) {
                hint.append(secretWord.charAt(i));
            } else {
                hint.append('#');
            }
        }

        while (hint.length() < HINT_LENGTH) {
            hint.append('#');
        }
        return hint.toString();
    }

    public static void main(String[] args) {
        System.out.println(findSymbolOccurrence("hello", 'l')); // 2

        System.out.println(findWordPosition("Apollo", "pollo")); // 1
        System.out.println(findWordPosition("Apple", "Plant")); // -1

        System.out.println(stringReverse("Hello")); // olleH

        System.out.println(isPalindrome("ERE")); // true
        System.out.println(isPalindrome("Allo")); // false

        guessingGame();
    }
}