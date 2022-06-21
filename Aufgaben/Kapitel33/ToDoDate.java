package Aufgaben.Kapitel33;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A ToDoDate represent a date with three int-Values. The value for the day may
 * only be between 1 and 31, the value for the month may only be between 1 and
 * 12, and the value for the year may only be less than 9999.
 * 
 * @author ESOP Team 2012
 */
public class ToDoDate {
	private int day;
	private int month;
	private int year;

	/**
	 * Constructs and initializes a {@link ToDoDate} with its day, month and year
	 * set to specified day, month and year.
	 * 
	 * @param dateString A String in of the format dd.mm.yyyy
	 * @throws ToDoDateException if the argument String does not match a valid date
	 */
	public ToDoDate(String dateString) {
		// Aufgabe 74
		// TODO: Implement throwing the ToDoDateException here
		this.day = Integer.valueOf(dateString.substring(0, 2));
		this.month = Integer.valueOf(dateString.substring(3, 5));
		this.year = Integer.valueOf(dateString.substring(6, dateString.length()));
	}

	/**
	 * Creates and returns the current date as a ToDoDate.
	 * 
	 * @return the current date as a ToDoDate
	 */
	public static ToDoDate getTodaysDate() {
		GregorianCalendar gc = new GregorianCalendar();
		ToDoDate tdd = null;
		try {
			int day = gc.get(Calendar.DAY_OF_MONTH);
			int month = gc.get(Calendar.MONTH) + 1;
			int year = gc.get(Calendar.YEAR);

			String dayS = String.valueOf(day);
			String monthS = String.valueOf(month);
			String yearS = String.valueOf(year);
			if (day < 10) {
				dayS = "0" + String.valueOf(day);
			}
			if (month < 10) {
				monthS = "0" + String.valueOf(month);
			}
			if (year < 10) {
				yearS = "000" + String.valueOf(year);
			} else if (year < 99) {
				yearS = "00" + String.valueOf(year);
			} else if (year < 999) {
				yearS = "0" + String.valueOf(year);
			}

			tdd = new ToDoDate(dayS + "." + monthS + "." + yearS);
		} catch (ToDoDateException e) {
			e.printStackTrace();
		}
		return tdd;
	}

	/**
	 * Returns the day of this ToDoDate.
	 * 
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Returns the month of this ToDoDate.
	 * 
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Returns the year of this ToDoDate.
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Returns a string representation of this this ToDoDate in the format
	 * DD.MM.YYYY.
	 * 
	 * @return the year
	 */
	public String toString() {
		String dayS = String.valueOf(day);
		String monthS = String.valueOf(month);
		String yearS = String.valueOf(year);

		if (day < 10) {
			dayS = "0" + String.valueOf(day);
		}
		if (month < 10) {
			monthS = "0" + String.valueOf(month);
		}
		if (year < 10) {
			yearS = "000" + String.valueOf(year);
		} else if (year < 99) {
			yearS = "00" + String.valueOf(year);
		} else if (year < 999) {
			yearS = "0" + String.valueOf(year);
		}
		return dayS + "." + monthS + "." + yearS;
	}
}
