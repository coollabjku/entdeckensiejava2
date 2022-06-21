package Loesungen.Kapitel33;

import java.util.Comparator;

/**
 * A ToDoEntryComparatorCreationDate compares two {@link ToDoEntry} objects for
 * order according to their creation dates.
 * 
 * @author ESOP Team 2012
 */
public class ToDoEntryComparatorCreationDate implements Comparator<ToDoEntry> {
	private ToDoDateComparator compDate = new ToDoDateComparator();

	/**
	 * Compares the two specified {@link ToDoEntry} objects.
	 * 
	 * @param entry1 the first {@link ToDoDateV2} to compare
	 * @param entry2 the second {@link ToDoDateV2} to compare
	 * 
	 * @return the value 0, a value less than 0 or a value greater than 0 according
	 *         to the following specification. <br>
	 *         0: if entry1.creationDate is equal to entry2.creationDate <br>
	 *         A value less than 0: if entry1.creationDate < entry2.creationDate
	 *         <br>
	 *         A value greater than 0: otherwise.<br>
	 *         <br>
	 * 
	 */
	public int compare(ToDoEntry entry1, ToDoEntry entry2) {
		// Compare the two creation dates.
		return compDate.compare(entry1.getCreationDate(), entry2.getCreationDate());
	}
}
