package Loesungen.Kapitel8;

import java.util.Scanner;

// Aufgabe 23
public class Glossary {
    static String[][] glossary = { { "array", "Zusammenfassung gleichartiger Komponenten ..." },
            { "variable", "Die Daten des Programms werden ..." },
            { "funktion", "Unterprogramm, welches beim Rücksprung ..." } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nWelches Wort möchten Sie " + "nachschlagen (ENTER zum Beenden)? ");
            String word = sc.nextLine();
            if (word.isEmpty()) {
                break;
            }

            boolean found = false;
            for (int i = 0; i < glossary.length && !found; i++) {
                if (glossary[i][0].equalsIgnoreCase(word)) {
                    System.out.println(glossary[i][1]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Eintrag nicht gefunden.");
            }
        }
        sc.close();
    }
}