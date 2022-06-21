package Loesungen.Kapitel8;

import java.util.Scanner;

// Aufgabe 22
public class Conjugator {
    static Scanner sc = new Scanner(System.in);
    static String[][] verbs = { { "sein", "essere", "sono", "sei", "e", "siamo", "siete", "sono" },
            { "haben", "avere", "ho", "hai", "ha", "abbiamo", "avete", "hanno" },
            { "gehen", "andare", "vado", "vai", "va", "andiamo", "andate", "vanno" },
            { "essen", "mangiare", "mangio", "mangi", "mangia", "mangiamo", "mangiate", "mangiano" },
            { "schlafen", "dormire", "dormo", "dormi", "dorme", "dormiamo", "dormite", "dormono" } };

    public static void conjugate(String input, int zahl) {
        for (int i = 0; i < verbs.length; i++) {
            if (verbs[i][0].equals(input) && zahl == 0) {
                for (int j = 0; j < verbs[0].length; j++) {
                    System.out.print(verbs[i][j] + ", ");
                }
            } else if (verbs[i][0].equals(input)) {
                System.out.println(verbs[i][zahl]);
            }
        }
    }

    public static void main(String[] args) {
        String input;
        int choice;
        System.out.print("Bitte Verb eingeben: ");
        input = sc.next();
        System.out.println("Für gewünschte Person bitte Zahl eingeben:");
        System.out.println("1 für Nennform");
        System.out.println("2 für 1. Person EZ");
        System.out.println("3 für 2. Person EZ");
        System.out.println("4 für 3. Person EZ");
        System.out.println("5 für 1. Person MZ");
        System.out.println("6 für 2. Person MZ");
        System.out.println("7 für 3. Person MZ");
        System.out.println("0 für alle Personen");
        choice = sc.nextInt();
        if (choice > 7 || choice < 0) {
            System.out.println("ungueltige Eingabe!");
        } else {
            conjugate(input, choice);
        }
    }
}