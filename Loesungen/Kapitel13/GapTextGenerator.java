package Loesungen.Kapitel13;

import java.util.*;

// Aufgabe 37
public class GapTextGenerator {
    public static void gapText(String text) {
        String[] words = text.split("\\s+");
        List<String> removedWords = new ArrayList<String>();
        int charCnt = 0;
        for (int i = 0; i < words.length; i++) {
            if (i % 7 == 6) {
                removedWords.add(words[i]);
                System.out.print("??? ");
            } else {
                System.out.print(words[i] + " ");
            }
            charCnt += words[i].length();
            // Zeilenumbruch, wenn mehr als 80 Zeichen
            if (charCnt > 80) {
                System.out.println();
                charCnt = 0;
            }
        }
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < removedWords.size(); i++) {
            System.out.printf("Wort %d? >> ", i);
            String s = sc.nextLine().trim();
            if (removedWords.get(i).equalsIgnoreCase(s)) {
                System.out.println("Die Antwort ist richtig.");
            } else {
                System.out.println("Die Antwort ist falsch.");
                System.out.println("Die richtige Antwort ist: " + removedWords.get(i));
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        String s = "Land der Berge Land am Strome Land der Äcker " + "Land der Dome Land der Hämmer zukunftsreich "
                + "Heimat großer Töchter und Söhne Volk begnadet " + "für das Schöne vielgerühmtes Österreich "
                + "Vielgerühmtes Österreich";
        gapText(s);
    }
}