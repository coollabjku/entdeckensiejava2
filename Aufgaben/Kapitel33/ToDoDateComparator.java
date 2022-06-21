package Aufgaben.Kapitel33;

import java.util.Comparator;

/**
 * A ToDoDateComparator compares two {@link ToDoDate}s for order.
 * 
 * @author ESOP Team 2012
 */
public class ToDoDateComparator implements Comparator<ToDoDate> {
	/**
	 * Compares the two specified {@link ToDoDate} objects.
	 * 
	 * @param date1 the first {@link ToDoDate} to compare
	 * @param date2 the second {@link ToDoDate} to compare
	 * @return the value 0 if date1 is equal to date2; a value less than 0 if date1
	 *         is less (before) date2; and a value greater than 0 if date1 is
	 *         greater (after) date2.
	 * 
	 */
	public int compare(ToDoDate date1, ToDoDate date2) {
		// First, get the year, month and day values for
		// each of the incoming ToDoDate objects.
		int year1 = date1.getYear();
		int year2 = date2.getYear();
		int month1 = date1.getMonth();
		int month2 = date2.getMonth();
		int day1 = date1.getDay();
		int day2 = date2.getDay();

		// First, compare the values of the two year variables.
		// If year1 is smaller than year2 return -1, if year1 is
		// greater than year 2 return 1. If year1 is equal to year2
		// continue by comparing month1 to month2 in a similar way.
		// if month1 is equal to month2, continue by comparing day1 to day2.
		// If day1 is equal to day2 there is nothing else to compare
		// and it can be concluded that date1 is equal to date2, thus
		// the method should return 0.

		// Aufgabe 72
		// TODO: Implement compare function here
		return 0;
	}
}
