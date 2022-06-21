package Aufgaben.Kapitel19;

/**
 * A helper class used to generate {@link Shape} objects.
 * 
 * @author ESOP Team 2012
 * 
 */
public class ShapeGenerator {
	private Shape[] shapes;

	/**
	 * Constructs and initializes a shape generator. The body of this constructor
	 * has to be modified at the marked position. Create more shapes and store them
	 * in the array!
	 */
	public ShapeGenerator() {
		shapes = new Shape[3];

		// Here create different shape-objects
		// and store them in the shapes-array.
		// shapes[0] = new Circle(100, 100, 20.0);
		// shapes[1] = new Circle(100, 200, 40.0);
		// shapes[2] = new Rectangle(40, 40, 20.0, 10.0);
	}

	/**
	 * Returns all the {@link Shape} objects created by this ShapeGenerator.
	 * 
	 * @return the shapes
	 */
	public Shape[] getShapes() {
		return shapes;
	}
}
