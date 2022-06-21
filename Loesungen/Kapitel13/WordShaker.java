package Loesungen.Kapitel13;

import java.util.*;

// Aufgabe 36
public class WordShaker {
    public String[] shakeWords1(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            int j = (int) (Math.random() * words.length);
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        }
        return words;
    }

    public String[] shakeWords2(String text) {
        String[] words = text.split(" ");
        List<String> li = Arrays.asList(words);
        Collections.shuffle(li);
        return words;
    }

    public void play(String text) {
        String[] words = shakeWords1(text);
        Scanner sc = new Scanner(System.in);
        boolean result;
        do {
            for (String w : words) {
                System.out.print(w + ' ');
            }
            System.out.print("\n>> ");
            String s = sc.nextLine();
            result = text.equalsIgnoreCase(s);
            System.out.printf("Die Antwort ist %s.\n\n", result ? "richtig" : "falsch");
        } while (!result);
        sc.close();
    }

    public static void main(String[] args) {
        String s1 = "Gutes kann niemals aus Lüge und Gewalt entstehen";
        String s2 = "Es gibt nichts Gutes außer man tut es";
        new WordShaker().play(s2);
    }
}