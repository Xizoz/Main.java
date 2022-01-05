// Jonatan Meyer mini-opgave Hangman Game 22-10-2020
// Lavet med inspiration fra SedaKunda på Github, https://gist.github.com/SedaKunda/79e1d9ddc798aec3a366919f0c14a078

package com.company;

import java.util.Scanner;

public class Main {

    private static String[] words = {"yoink", "datalogi", "jazz", "galge", "uskyldig", "henrettelse"};
    private static String word = words[(int) (Math.random() * words.length)];
    private static String stjerne = new String(new char[word.length()]).replace("\0", "*");
    private static int count = 0;

    /*
    I det ovenstående kode er der mine 6 ord, som kan gættes i spillet. Derudover står der at et tilfældigt ord
    skal vælges og erstattes med en stjerner, antallet af stjerner bestemmes af ordets længde.
     */

    public static void main(String[] args) {
        System.out.println("Welcome to my Hangman Game, the words are in danish, just so you know ;)");
        System.out.println("You have 8 guesses to get it right, and if you do you get a special prize!");
        Scanner sc = new Scanner(System.in);

        // I det ovenstående kode printer jeg spillets regler og starter scanneren, så den kan læse brugerinput.

        while (count < 8 && stjerne.contains("*")) {
            System.out.println("Try and guess the letters of the word by typing a letter, and pressing enter!");
            System.out.println(stjerne);
            String guess = sc.next();
            hang(guess);
        }
        sc.close();
    }
    /*
    I det ovenstående kode starter jeg et while loop som printer ordet med stjerner, samt scanner brugerinput,
     og sætter det ind i variablen guess, den læser dog kun det første bogstav i brugerinputtet.
     */

    public static void hang(String guess) {
        String newStjerne = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newStjerne += guess.charAt(0);
            } else if (stjerne.charAt(i) != '*') {
                newStjerne += word.charAt(i);
            } else {
                newStjerne += "*";
            }
        }
        /*
        I det ovenstående kode står der, hvis et bruger indtastet bogstav er det samme som et i ordet skal, en stjerne
        erstattes med bogstavet.
         */

        if (stjerne.equals(newStjerne)) {
            count++;
            hangmanImage();
        } else {
            stjerne = newStjerne;
        }
        if (stjerne.equals(word)) {
            System.out.println("Correct! You win! The word was " + word);
            System.out.println("And here is your special prize: shorturl.at/bcdDL ");
        }
        // Det ovenstående stykke kode kører hvis brugeren gætter alle bogstaverne i et af orderne, og så får man et speical prize :)
    }


    public static void hangmanImage() {
        if (count == 1) {
            System.out.println("Wrong guess sorry, you have 7 guesses left");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
            System.out.println("Wrong guess sorry, you have 6 guesses left");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("Wrong guess sorry, you have 5 guesses left");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("Wrong guess sorry, you have 4 guesses left");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("Wrong guess sorry, you have 3 guesses left");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
            System.out.println("Wrong guess sorry, you have 2 guesses left");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("Wrong guess sorry, you have 1 guess left");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         / . . \\");
            System.out.println("   |        |   .  |");
            System.out.println("               ___       ");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");

        }

        if (count == 8) {
            System.out.println("GAME OVER, the man is dead :(");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         / x x \\");
            System.out.println("   |        |   .  |");
            System.out.println("               ___      ");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + word);

        }
        // De ovenstående 8 if statements bliver printet til konsolen når du har gættet forkert, de bliver printet i rækkefølge med antallet af forkerte gæt.

    }
}