package Loesungen.Kapitel8;

import java.io.*;
import java.util.*;

// Aufgabe 25
public class Dictionary {
    private List<String[]> dict;
    private String[] languages;

    public Dictionary() throws IOException {
        dict = new ArrayList<String[]>();
        BufferedReader br = new BufferedReader(new FileReader("Familie.txt"));
        languages = br.readLine().split("\t");
        while (br.ready()) {
            String[] sa = br.readLine().split("\t");
            if (sa.length == languages.length) {
                dict.add(sa);
            }
        }
        br.close();
    }

    public String translate(int langFrom, int langTo, String s) {
        for (String[] entry : dict) {
            if (entry[langFrom].equalsIgnoreCase(s)) {
                return entry[langTo];
            }
        }
        return null;
    }

    private void printLanguageInfo() {
        for (int i = 0; i < languages.length; i++) {
            System.out.printf("%d. %s\n", i, languages[i]);
        }
    }

    private void showDialog() {
        Scanner sc = new Scanner(System.in);
        printLanguageInfo();
        int maxLangNr = languages.length - 1;
        int langFrom = -1;
        while (true) {
            System.out.print("Ausgangssprache Nr? ");
            try {
                langFrom = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
            }
            if (0 <= langFrom && langFrom <= maxLangNr) {
                break;
            } else {
                System.out.printf("FEHLER: Eine Zahl zwischen 0 und %d eingeben.\n", maxLangNr);
            }
        }

        int langTo = -1;
        while (true) {
            System.out.print("Zielsprache Nr? ");
            try {
                langTo = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            }
            if (0 <= langTo && langTo <= maxLangNr) {
                break;
            } else {
                System.out.printf("FEHLER: Eine Zahl zwischen 0 und %d eingeben.\n", maxLangNr);
            }
        }

        System.out.printf("Übersetze von %s nach %s.\n", languages[langFrom], languages[langTo]);
        while (true) {
            System.out.print("\nWort zu Übersetzen (ENTER zum Beenden)? ");
            String word = sc.nextLine();
            if (word.isEmpty()) {
                break;
            }
            String translation = translate(langFrom, langTo, word);
            if (translation != null) {
                System.out.println("Übersetzung: " + translation);
            } else {
                System.out.println("Eintrag nicht gefunden.");
            }

        }
        sc.close();
    }

    public static void main(String[] args) throws IOException {
        new Dictionary().showDialog();
    }
}