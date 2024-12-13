package app;

import java.util.Random;
import java.util.Scanner;

public class MainProgram {
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
        String reversed = stringReverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public static void guessingGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);
        boolean guessed = false;

        System.out.println("Guess the word!");

        while (!guessed) {
            System.out.print("Your guess: ");
            String userGuess = scanner.nextLine().toLowerCase();

            if (userGuess.equals(secretWord)) {
                guessed = true;
                System.out.println("Congratulations! You guessed the word.");
            } else {
                StringBuilder hint = new StringBuilder();
                for (int i = 0; i < secretWord.length(); i++) {
                    if (i < userGuess.length() && secretWord.charAt(i) == userGuess.charAt(i)) {
                        hint.append(secretWord.charAt(i));
                    } else {
                        hint.append('#');
                    }
                }
                while (hint.length() < 15) {
                    hint.append('#');
                }
                System.out.println("Hint: " + hint);
            }
        }
        scanner.close();
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