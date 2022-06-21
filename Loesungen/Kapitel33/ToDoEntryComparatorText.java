package Loesungen.Kapitel33;

import java.util.Comparator;

public class ToDoEntryComparatorText implements Comparator<ToDoEntry> {

    // Aufgabe 73
    public int compare(ToDoEntry entry1, ToDoEntry entry2) {
        // Compare the two texts.
        return entry1.getText().compareToIgnoreCase(entry2.getText());
    }
}
