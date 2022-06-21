package Loesungen.Kapitel33;

import java.util.Collections;
import java.util.Vector;

/**
 * A small test program to test the implementation of the sorting and comparing
 * of {@link ToDoEntry} objects. By removing the corresponding comments in the
 * code a set of ToDoEntry objects will be sorted using either a
 * {@link ToDoEntryComparatorDeadlineDate} comparator, a
 * {@link ToDoEntryComparatorCreationDate} object, or a
 * {@link ToDoEntryComparatorText} object.
 * 
 * @author ESOP Team 2012
 */
public class ToDoEntrySortRun {
	public static void main(String[] args) {
		// First create some ToDoEntry objects.
		ToDoEntry tde0 = new ToDoEntry("A");
		ToDoEntry tde1 = new ToDoEntry(new ToDoDate("10.01.2013"), new ToDoDate("15.01.2013"), "A");
		ToDoEntry tde2 = new ToDoEntry(new ToDoDate("10.01.2013"), new ToDoDate("15.01.2013"), "B");
		ToDoEntry tde3 = new ToDoEntry(new ToDoDate("10.01.2014"), new ToDoDate("15.01.2014"), "A");
		ToDoEntry tde4 = new ToDoEntry(new ToDoDate("01.01.2013"), "C");
		ToDoEntry tde5 = new ToDoEntry("CD");
		ToDoEntry tde6 = new ToDoEntry("cD");
		ToDoEntry tde7 = new ToDoEntry(new ToDoDate("01.01.2011"), new ToDoDate("01.01.2012"), "cD");
		ToDoEntry tde8 = new ToDoEntry(new ToDoDate("01.01.2013"), new ToDoDate("01.02.2013"), "cD");
		ToDoEntry tde9 = new ToDoEntry(new ToDoDate("01.01.2012"), new ToDoDate("01.01.2012"), "a");

		// Add the 10 ToDoEntry objects to a Collection object
		Vector<ToDoEntry> vec = new Vector<ToDoEntry>();
		vec.add(tde0);
		vec.add(tde1);
		vec.add(tde2);
		vec.add(tde3);
		vec.add(tde4);
		vec.add(tde5);
		vec.add(tde6);
		vec.add(tde7);
		vec.add(tde8);
		vec.add(tde9);

		// Print all elements in the collection
		printAll(vec);

		// Aufgabe 73

		// Now try to sort using a ToDoEntryComparatorCreationDate object
		ToDoEntryComparatorCreationDate compCreation = new ToDoEntryComparatorCreationDate();
		Collections.sort(vec, compCreation);

		// Now try to sort using a ToDoEntryComparatorDeadlineDate object
		ToDoEntryComparatorDeadlineDate compDeadline = new ToDoEntryComparatorDeadlineDate();
		Collections.sort(vec, compDeadline);

		// Now try to sort using a ToDoEntryComparatorDeadlineDate object
		ToDoEntryComparatorText compText = new ToDoEntryComparatorText();
		Collections.sort(vec, compText);

		// Print all elements in the collection after sort
		printAll(vec);

	}

	public static void printAll(Vector<ToDoEntry> v) {
		for (ToDoEntry tde : v) {
			System.out.println(tde);
		}
		System.out.println();
	}

}
