package Aufgaben.Kapitel7;

// Aufgabe 18
public class ImageMirror {
    public static short[][] flipH(short[][] image) {
        // TODO: Replace method body
        return null;
    }

    public static short[][] flipV(short[][] image) {
        // TODO: Replace method body
        return null;
    }

    public static short[][] emptyArray(short[][] a) {
        // TODO: Replace method body
        return null;
    }

    public static void main(String[] args) {
        short[][] image = BWPicture.load("Baum.jpg");
        BWPicture.show(image, "Original");
        BWPicture.show(flipH(image), "Flip horizontal");
        BWPicture.show(flipV(image), "Flip vertikal");
    }
}