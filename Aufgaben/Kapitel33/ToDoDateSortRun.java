package Aufgaben.Kapitel33;

import java.util.Collections;
import java.util.Vector;

/**
 * A small test program to test the implementation of the sorting and comparing
 * of {@link ToDoDate} objects. Carefully read the code comments! Is used for
 * Aufgabenblatt 6, Aufgabe 8. The code comments explain how ToDoDate objects
 * can be compared using a Comparator object.
 * 
 * @author ESOP Team 2012
 */
public class ToDoDateSortRun {
	public static void main(String[] args) {
		// Create four arbitrary ToDoDate objects.
		ToDoDate date1 = new ToDoDate("11.03.2013");
		ToDoDate date2 = new ToDoDate("10.03.2013");
		ToDoDate date3 = new ToDoDate("10.03.2014");
		ToDoDate date4 = new ToDoDate("10.04.2013");

		// Create a Vector that can hold ToDoDate objects.
		Vector<ToDoDate> tododateVector = new Vector<ToDoDate>();

		// Put the ToDoDate objects in the Vector.
		tododateVector.add(date1);
		tododateVector.add(date2);
		tododateVector.add(date3);
		tododateVector.add(date4);

		// Print the content of the Vector to the console.
		// Iterate through the Vector, from the first to the last object.
		for (ToDoDate tdd : tododateVector) {
			// We can do this because the ToDoDate class implements
			// the toString()-Method, which creates a String representation
			// of the ToDoDate object!
			System.out.println(tdd);
		}

		/*
		 * Now sort the Vector. To sort the Vector we will make use of the utility class
		 * "Collections"
		 * (http://docs.oracle.com/javase/7/docs/api/java/util/Collections.html). This
		 * class provides methods that operate on collection objects. The tododateVector
		 * is a collection, a collection of ToDoDate objects.
		 * 
		 * To sort the tododateVector we use one of the sort methods provided by the
		 * Collections class. The sort method we pick requires two arguments: 1: an
		 * object that is a subclass of an AbstractCollecton (our tododateVector of
		 * ToDoDate objects is an instance of such a class), and 2: an object that
		 * implements the Comparator interface
		 * (http://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html). This
		 * interface specifies one method that we need to implement: its compare method.
		 * This method requires two parameters, the two objects to be compared. In our
		 * case, two ToDoDate objects. The method returns an int value to signal the
		 * result of the comparison.
		 * 
		 * The return value should either be 0, less than 0 or greater than 0.
		 * 
		 * We call the first parameter (incoming object) date1 and the second parameter
		 * (incoming object) date2. Now, the compare method should return:
		 * 
		 * 0 if date1.day == date2.day, and date1.month == date2.month, and date1.year
		 * == date2.year
		 * 
		 * -1 if the date1 object is regarded to be "less" than the date2 object. To
		 * determine which is less, we first have to decide on the "natural ordering" of
		 * ToDoDate objects. It seems "natural" to say that a ToDoDate object which
		 * represents a date that is closer to year 0 (birth of Christ) is less than a
		 * ToDoDate object that represents a date that is further away from year 0,
		 * i.e., closer to today. So, -1 should be returned if date1 is less than date2.
		 * 
		 * 1 if the date1 object is regarded to be "greater" than the date2 object
		 * according to the previous reasoning.
		 * 
		 * -----------------------------------------------------------------------------
		 * -
		 * 
		 * Now, use the prepared ToDoDateComparator class and provide the necessary code
		 * in its public int compare(ToDoDate date1, ToDoDate date2) method.
		 * 
		 * When you are done, remove the next block comment to see if your
		 * implementation correctly sorts the tododateVector!
		 * 
		 * If correct, the program will generate the following output: 11.03.2013
		 * 10.03.2013 10.03.2014 10.04.2013 After a call to Collections.sort: 10.03.2013
		 * 11.03.2013 10.04.2013 10.03.2014
		 * 
		 */

		// Aufgabe 72
		// TODO: Remove comment to test your ToDoDateComparator!

		// System.out.println("After a call to Collections.sort:");

		// First create a ToDoDateComparator.
		// ToDoDateComparator myComparator = new ToDoDateComparator();

		// Now pass the tododateVector and the Comparator object to
		// the compare method in class Collections. This method will
		// go through all elements (objects) contained in the tododateVector and
		// use myComparator and its compare method to compare the
		// contained ToDoDate objects and sort the tododateVector accordingly.

		// Collections.sort(tododateVector, myComparator);

		// Now the tododateVector should be sorted. Loop through the vector
		// and print to the console.
		for (ToDoDate tdd : tododateVector) {
			System.out.println(tdd);
		}

	}
}
