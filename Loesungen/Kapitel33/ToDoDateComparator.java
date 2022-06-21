package Loesungen.Kapitel33;

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

		// Alternative: Sum up weighted date segments
		int dateSum1 = (year1 * 10000 + month1 * 100 + day1);
		int dateSum2 = (year2 * 10000 + month2 * 100 + day2);
		// then flatten them to either -1 or +1, if they arent the same
		if (dateSum1 > dateSum2)
			return 1;
		if (dateSum1 < dateSum2)
			return -1;

		return 0;

		// INSERT YOUR CODE HERE
		// else not necessary but kept for semantics
		/*
		 * if (year1 < year2) return -1; else if (year1 > year2) return 1;
		 * 
		 * if (month1 < month2) return -1; else if (month1 > month2) return 1;
		 * 
		 * if (day1 < day2) return -1; else if (day1 > day2) return 1;
		 * 
		 * return 0;
		 */
	}
}
