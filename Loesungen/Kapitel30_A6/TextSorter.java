package Loesungen.Kapitel30_A6;

import java.util.*;

// Aufgabe 67
public class TextSorter {
    protected final List<String> texts;

    public TextSorter() {
        texts = new Vector<>();
    }

    public void addText(String text) {
        texts.add(text);
    }

    public void listContent() {
        for (String s : texts) {
            System.out.println(s);
        }
    }

    public void sortContent() {
        Collections.sort(texts);
    }
}