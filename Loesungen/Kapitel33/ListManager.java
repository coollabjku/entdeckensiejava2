package Loesungen.Kapitel33;

import java.util.Collections;
import java.util.Vector;

/**
 * A ListManager is used by the {@link ToDoApp}. A ListManager is responsible
 * for sorting the {@link ToDoEntry} objects contained in the ToDo list. A
 * ListManager also manages the data structure holding the ToDo-entries (a
 * Vector<ToDoEntry> object).
 * 
 * @author ESOP Team 2012
 */
public class ListManager {
	/**
	 * Possible sort value for sorting a ToDo-list. Sort the list according to to
	 * the creation date of the ToDoEntry objects.
	 */
	public static final int CREATIONDATE_SORT = 0;
	/**
	 * Possible sort value for sorting a ToDo-list. Sort the list according to to
	 * the deadline date of the ToDoEntry objects.
	 */
	public static final int DEADLINEDATE_SORT = 1;
	/**
	 * Possible sort value for sorting a ToDo-list. Sort the list according to to
	 * the text of the ToDoEntry objects.
	 */
	public static final int TEXT_SORT = 2;

	private Vector<ToDoEntry> listEntries;

	/**
	 * Constructs and initializes a {@link ListManager} object.
	 * 
	 * @param data the String representations of ToDoEntry objects.
	 */
	public ListManager(Vector<String[]> data) {
		listEntries = new Vector<ToDoEntry>();
		for (String[] arr : data) {
			String creationString = new String(
					arr[0].substring(0, 2) + "." + arr[0].substring(2, 4) + "." + arr[0].substring(4, 8));
			ToDoDate creationDate = new ToDoDate(creationString);
			ToDoDate deadlineDate;
			if (!arr[1].equals("")) {
				String deadlineString = new String(
						arr[1].substring(0, 2) + "." + arr[1].substring(2, 4) + "." + arr[1].substring(4, 8));
				deadlineDate = new ToDoDate(deadlineString);
			} else {
				deadlineDate = null;
			}
			listEntries.add(new ToDoEntry(creationDate, deadlineDate, arr[2]));
		}
	}

	/**
	 * @param sortType
	 * @return the String representations of the ToDoEntry objects contained in the
	 *         list managed by this {@link ListManager} in a sorted order
	 * @throws IllegalArgumentException if a unknown sortType is requested<br>
	 *                                  <br>
	 *                                  Currently a three sort orders are know:<br>
	 *                                  <br>
	 *                                  1) according to creation date
	 *                                  ({@link ListManager#CREATIONDATE_SORT})<br>
	 *                                  2) according to deadline date
	 *                                  ({@link ListManager#DEADLINEDATE_SORT})<br>
	 *                                  3) according to entry text
	 *                                  ({@link ListManager#TEXT_SORT})<br>
	 */
	public Vector<Vector<String>> sortToDoEntries(int sortType) throws IllegalArgumentException {
		if (sortType != -1) {
			if (sortType == ListManager.CREATIONDATE_SORT) {
				// first creation date, then text, then deadline date
				Collections.sort(listEntries, new ToDoEntryComparatorCreationDate());
			} else if (sortType == ListManager.DEADLINEDATE_SORT) {
				// first deadline date, then text, then creation date
				Collections.sort(listEntries, new ToDoEntryComparatorDeadlineDate());
			} else if (sortType == ListManager.TEXT_SORT) {
				// first text, then creation date, then deadline date
				Collections.sort(listEntries, new ToDoEntryComparatorText());
			} else {
				String message = "non-valid sort option";
				throw new IllegalArgumentException(message);
			}
		}

		// Now is the listEntries Vector sorted as desired. Return back the
		// String representations of the ToDoEntries to the graphical user interface
		// for display to the user.
		Vector<Vector<String>> stringList = new Vector<Vector<String>>();
		Vector<String> v = new Vector<String>();
		for (ToDoEntry tde : listEntries) {
			v = new Vector<String>();
			v.add(tde.getCreationDate().toString());
			v.add(tde.getDeadlineDate() != null ? tde.getDeadlineDate().toString() : "");
			v.add(tde.getText());
			stringList.add(v);
		}
		return stringList;
	}

	protected void setToDoList(Vector<Vector<String>> data) {
		listEntries.removeAllElements();
		for (Vector<String> v : data) {
			ToDoDate creationDate = new ToDoDate(v.get(0));
			ToDoDate deadlineDate;
			if (v.get(1).equals("")) {
				deadlineDate = null;
			} else {
				deadlineDate = new ToDoDate(v.get(1));
			}
			String text = v.get(2).toString();
			listEntries.add(new ToDoEntry(creationDate, deadlineDate, text));
		}
	}

	protected Vector<String> getAttributeNames() {
		return ToDoEntry.getAttributeNames();
	}
}
