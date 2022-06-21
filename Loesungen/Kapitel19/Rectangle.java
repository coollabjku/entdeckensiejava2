package Loesungen.Kapitel19;

// Aufgabe 51
public class Rectangle implements Shape {
    private int posX;
    private int posY;
    private double width;
    private double height;

    public Rectangle(int posX, int posY, double width, double height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public void translate(int dx, int dy) {
        posX += dx;
        posY += dy;
    }

    public void scale(double factor) {
        width *= factor;
        height *= factor;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    public String toString() {
        return "RECTANGLE[location=" + posX + "," + posY + " width=" + width + " height=" + height + " perimeter="
                + getPerimeter();
    }
}
