package Aufgaben.Kapitel32;

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
		// Aufgabe 70
		// TODO: Change the code here
		double d = 12; // new Double.parseDouble(args[0]);
		double root = calculateSquareRoot(d);
		System.out.println("The square root of " + d + " is " + root);
	}

	/**
	 * Returns the square root of the specified number.
	 * 
	 * @param d a value
	 * @return the square root of a
	 * @throws ImaginaryNumberException if d is a negative value
	 */
	public static double calculateSquareRoot(double d) {
		// Aufgabe 71
		return Math.sqrt(d);
	}
}
