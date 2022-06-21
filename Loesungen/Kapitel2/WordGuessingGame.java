package Loesungen.Kapitel2;

import java.util.Scanner;

// Aufgabe 4
public class WordGuessingGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Bitte Ratewort eingeben: ");
        String word = sc.next();
        String guess = "";

        // while-loop solution
        while (!guess.equalsIgnoreCase("ende")) {
            System.out.print("Raten Sie! (zum Beenden das Wort ende eingeben): ");
            guess = sc.next();

            if (word.equalsIgnoreCase(guess)) {
                System.out.print("Congratulations! Noch eine Runde? ja/nein eingeben: ");
                guess = sc.next();
                if (guess.equalsIgnoreCase("nein")) {
                    guess = "ende";
                } else {
                    System.out.print("Bitte Ratewort eingeben: ");
                    word = sc.next();
                }
            } else if (!guess.equalsIgnoreCase("ende")) {
                System.out.println("Leider falsch!");
            }
        }

        // do-while-loop solution
        // do {
        // System.out.print("Raten Sie! (zum Beenden das Wort ende eingeben): ");
        // guess = sc.next();
        // if (word.equalsIgnoreCase(guess)) {
        // System.out.print("Congratulations! Noch eine Runde? ja/nein eingeben: ");
        // guess = sc.next();
        // if (guess.equalsIgnoreCase("nein")) {
        // guess = "ende";
        // } else {
        // System.out.print("Bitte Ratewort eingeben: ");
        // word = sc.next();
        // }
        // } else if (!guess.equalsIgnoreCase("ende")) {
        // System.out.println("Leider falsch!");
        // }
        // } while (!guess.equalsIgnoreCase("ende"));

        // for-loop solution
        // for (; !guess.equalsIgnoreCase("ende");) {
        // System.out.print("Raten Sie! (zum Beenden das Wort ende eingeben): ");
        // guess = sc.next();

        // if (word.equalsIgnoreCase(guess)) {
        // System.out.print("Congratulations! Noch eine Runde? ja/nein eingeben: ");
        // guess = sc.next();
        // if (guess.equalsIgnoreCase("nein")) {
        // guess = "ende";
        // } else {
        // System.out.print("Bitte Ratewort eingeben: ");
        // word = sc.next();
        // }
        // } else if (!guess.equalsIgnoreCase("ende")) {
        // System.out.println("Leider falsch!");
        // }
        // }

        System.out.println("goodbye");
    }
}