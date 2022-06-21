package Loesungen.Kapitel13;

import java.util.Scanner;

// Aufgabe 39
public class CapitalizationChecker {
    private String text;
    private String[] words;
    private boolean[] upperCase;
    private int correctAnswersCount;

    public CapitalizationChecker(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Kein Text!");
        }
        this.text = text;
        words = text.split(" ");
        upperCase = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (Character.isUpperCase(words[i].charAt(0))) {
                words[i] = words[i].toLowerCase();
                upperCase[i] = true;
            }
        }
    }

    public void performExercise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib r oder f ein, je nach dem ob Groß- Kleinschreibung"
                + "beim Wort nach dem Pfeil richtig oder falsch ist.\n");
        for (int i = 0; i < words.length; i++) {
            print(i);
            char c = ' ';
            do {
                System.out.print("> ");
                String s = sc.nextLine();
                if (s.length() > 0) {
                    c = s.toLowerCase().charAt(0);
                }
            } while (c != 'r' && c != 'f');
            if ((c == 'f' && upperCase[i]) || (c == 'r' && !upperCase[i])) {
                correctAnswersCount++;
            }
        }
        sc.close();
        System.out.printf("Du hast %d von %d Antworten richtig.\n", correctAnswersCount, words.length);

        System.out.printf("Der richtige Text: %s\n", text);
    }

    public void print(int pos) {
        for (int i = 0; i < words.length; i++) {
            if (i == pos) {
                System.out.print("=>");
            }
            System.out.print(words[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "Gutes kann niemals aus Lüge und Gewalt entstehen.";
        CapitalizationChecker aufgabe14 = new CapitalizationChecker(s);
        aufgabe14.performExercise();
    }
}
