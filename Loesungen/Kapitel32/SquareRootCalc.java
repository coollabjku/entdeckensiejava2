package Loesungen.Kapitel32;

/**
 * A small program that finds the square root of a number.
 * 
 * The application requires a program parameter (the number used to find the
 * square root).
 * 
 * @author ESOP Team 2012
 * 
 */
public class SquareRootCalc {
	public static void main(String[] args) {
		try {
			double d = 12; // new Double.parseDouble(args[0]);
			double root = calculateSquareRoot(d);
			System.out.println("The square root of " + d + " is " + root);
		} catch (NumberFormatException | ImaginaryNumberException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Returns the square root of the specified number.
	 * 
	 * @param d a value
	 * @return the square root of a
	 * @throws ImaginaryNumberException if d is a negative value
	 */
	public static double calculateSquareRoot(double d) {
		if (d >= 0) {
			return Math.sqrt(d);
		} else {
			// Aufgabe 71
			throw new ImaginaryNumberException("Cannot take the square root of a negative number");
		}
	}
}
