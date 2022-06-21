package Loesungen.Kapitel33;

import java.util.Vector;

/**
 * A ToDoEntry consists of two {@link ToDoDate} objects (one representing the
 * creation date of the ToDoEntry, one representing the deadline for the
 * ToDoEntry) and a {@link String} of text.<br>
 * <br>
 * The deadline may be null.
 * 
 * @author ESOP Team 2012
 */
public class ToDoEntry {
	private ToDoDate creationDate;
	private ToDoDate deadlineDate;
	private String text;

	/**
	 * Constructs and initializes a {@link ToDoEntry} with its creation date,
	 * deadline and text set to the specified values.
	 * 
	 * @param creationDate the creation date for this {@link ToDoEntry}
	 * @param deadlineDate the deadline date for this {@link ToDoEntry}
	 * @param text         the text description of this {@link ToDoEntry}
	 * @throws IllegalArgumentException if the specified deadline date is earlier
	 *                                  than the creation date!
	 */
	public ToDoEntry(ToDoDate creationDate, ToDoDate deadlineDate, String text) {
		// Aufgabe 75
		if (new ToDoDateComparator().compare(creationDate, deadlineDate) == 1)
			throw new IllegalArgumentException(
					"Deadline " + deadlineDate + " is earlier than creation date " + creationDate);
		this.creationDate = creationDate;
		this.deadlineDate = deadlineDate;
		this.text = text;
	}

	/**
	 * Constructs and initializes a ToDoEntry with a creation date set to today's
	 * date, its deadline set to the specified date and its text set to the
	 * specified text.
	 * 
	 * @param deadlineDate the deadline date for this {@link ToDoEntry}
	 * @param text         the text description of this {@link ToDoEntry}
	 */
	public ToDoEntry(ToDoDate deadlineDate, String text) {
		this(ToDoDate.getTodaysDate(), deadlineDate, text);
	}

	/**
	 * Constructs and initializes a ToDoEntry with a creation date set to today's
	 * date, no deadline, and with its text set to the specified text.
	 * 
	 * @param text the text description of this {@link ToDoEntry}
	 */
	public ToDoEntry(String text) {
		this(ToDoDate.getTodaysDate(), null, text);
	}

	/**
	 * Removes the deadline of this ToDoEntry.
	 */
	public void removeDeadline() {
		this.deadlineDate = null;
	}

	/**
	 * Returns the deadline date.
	 * 
	 * @return the deadline date, null if no deadline is set
	 */
	public ToDoDate getDeadlineDate() {
		return deadlineDate;
	}

	/**
	 * Sets the deadline date of this ToDoEntry.
	 * 
	 * @param deadline the deadline to set
	 * @throws IllegalArgumentException if the null is passed or if the specified
	 *                                  deadline date is in the past.
	 */
	public void setDeadlineDate(ToDoDate deadline) {
		this.deadlineDate = deadline;
	}

	/**
	 * Returns the text description of this ToDoEntry.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text description of this ToDoEntry.
	 * 
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returns the creation date of this ToDoEntry.
	 * 
	 * @return the creationDate
	 */
	public ToDoDate getCreationDate() {
		return creationDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String retValue = "";
		retValue = "[Creation date: " + this.creationDate;

		if (this.deadlineDate != null) {
			retValue = retValue + ", Deadline: " + this.deadlineDate;
		} else {
			retValue = retValue + ", Deadline: " + "nodeadline";
		}

		retValue = retValue + ", Text: " + this.getText() + "]";
		return retValue;
	}

	protected static Vector<String> getAttributeNames() {
		Vector<String> vec = new Vector<String>();
		vec.add("Creation Date");
		vec.add("Deadline Date");
		vec.add("Text");
		return vec;
	}
}
