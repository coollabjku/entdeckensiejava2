package Loesungen.Kapitel33;

import java.util.Comparator;

public class ToDoEntryComparatorDeadlineDate implements Comparator<ToDoEntry> {
    private ToDoDateComparator compDate = new ToDoDateComparator();

    // Aufgabe 73
    public int compare(ToDoEntry entry1, ToDoEntry entry2) {
        // Compare the two deadline dates.
        if (entry1.getDeadlineDate() == null && entry2.getDeadlineDate() == null)
            return 0;
        if (entry1.getDeadlineDate() == null)
            return 1;
        if (entry2.getDeadlineDate() == null)
            return -1;
        return compDate.compare(entry1.getDeadlineDate(), entry2.getDeadlineDate());
    }
}
