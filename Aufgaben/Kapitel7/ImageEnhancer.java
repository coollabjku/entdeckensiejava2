package Aufgaben.Kapitel7;

// Aufgabe 17
public class ImageEnhancer {
    public static short[][] enhance(short[][] image, double f) {
        // TODO: Replace method body
        return null;
    }

    public static void main(String[] args) {
        short[][] image = BWPicture.load("Baum.jpg");
        BWPicture.show(image, "Original");
        BWPicture.show(enhance(image, 1.8), "* 1.8");
    }
}