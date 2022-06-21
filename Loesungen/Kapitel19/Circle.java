package Loesungen.Kapitel19;

// Aufgabe 51
public class Circle implements Shape {
    private int centerX;
    private int centerY;
    private double radius;

    public Circle(int centerX, int centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public void translate(int dx, int dy) {
        centerX += dx;
        centerY += dy;
    }

    public void scale(double factor) {
        radius *= factor;
    }

    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public String toString() {
        return "CIRCLE[location=" + centerX + "," + centerY + " radius=" + radius + " perimeter=" + getPerimeter();
    }
}
