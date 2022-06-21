package Aufgaben.Kapitel7;

// Aufgabe 19
public class ImageEdgeFilter {
    public static short[][] edgeFilter(short[][] image, int delta) {
        // TODO: Replace method body
        return null;
    }

    public static void main(String[] args) {
        short[][] image = BWPicture.load("Baum.jpg");
        BWPicture.show(image, "Original");
        BWPicture.show(edgeFilter(image, 20), "delta=20");
    }
}