package Loesungen.Kapitel30_A6;

import java.util.Collections;

// Aufgabe 68
public class TextReverseSorter2 extends TextSorter {
    @Override
    public void sortContent() {
        Collections.sort(texts, Collections.reverseOrder());
    }
}