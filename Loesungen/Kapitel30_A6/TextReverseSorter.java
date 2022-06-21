package Loesungen.Kapitel30_A6;

import java.util.Collections;
import java.util.Comparator;

// Aufgabe 68
public class TextReverseSorter extends TextSorter {
    @Override
    public void sortContent() {
        Collections.sort(texts, reverse);
    }

    Comparator<String> reverse = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return s2.compareTo(s1);
        }
    };
}
