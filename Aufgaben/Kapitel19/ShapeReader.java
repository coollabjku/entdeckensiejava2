package Aufgaben.Kapitel19;

/**
 * A test program to test the implementation of the interface {@link Shape} and
 * the classes {@link Circle} and {@link Rectangle}.
 * 
 * @author ESOP Team 2012
 * 
 */
public class ShapeReader {

	public static void main(String[] args) {
		ShapeGenerator sg = new ShapeGenerator();
		Shape[] myShapes = sg.getShapes();

		printShapeInformation(myShapes);
		System.out.println();

		System.out.println("translation (x+10)");
		translateShapes(myShapes, 10, 0);
		printShapeInformation(myShapes);
		System.out.println();

		System.out.println("scaling (factor 0.5)");
		scaleShapes(myShapes, 0.5);
		printShapeInformation(myShapes);
		System.out.println();

		scaleShapes(myShapes, 0.5);
		printShapeInformation(myShapes);
		System.out.println();

		System.out.println("perimeters");
		getPerimeters(myShapes);

	}

	/**
	 * Prints the shape information of all {@link Shape} objects contained in the
	 * specified array.
	 * 
	 * @param s an array with {@link Shape} objects
	 */
	private static void printShapeInformation(Shape[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	/**
	 * Translates all {@link Shape}s contained in the specified array by a
	 * horizontal displacement dx and a vertical displacement dy.
	 * 
	 * @param shapes an array with {@link Shape} objects
	 * @param dx     horizontal displacement
	 * @param dy     vertical displacement
	 */
	private static void translateShapes(Shape[] shapes, int dx, int dy) {
		for (int i = 0; i < shapes.length; i++) {
			// shapes[i].translate(dx, dy);
		}
	}

	/**
	 * Scales all {@link Shape}s contained in the specified array by the specified
	 * factor.
	 * 
	 * @param shapes an array with {@link Shape} objects
	 * @param factor scaling factor
	 */
	private static void scaleShapes(Shape[] shapes, double factor) {
		for (int i = 0; i < shapes.length; i++) {
			// shapes[i].scale(factor);
		}
	}

	/**
	 * Writes the perimeter of all {@link Shape}s contained in the specified array
	 * to System.out.
	 * 
	 * @param shapes an array with {@link Shape} objects
	 */
	private static void getPerimeters(Shape[] shapes) {
		for (int i = 0; i < shapes.length; i++) {
			// System.out.println(shapes[i].getPerimeter());
		}
	}
}
