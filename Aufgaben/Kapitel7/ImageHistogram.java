package Aufgaben.Kapitel7;

// Aufgabe 20
public class ImageHistogram {
    public static int[] histogram(short[][] image) {
        // TODO: Replace method body
        return null;
    }

    public static short[][] histImage(int h[], int displayHeight) {
        // TODO: Replace method body
        return null;
    }

    public static void main(String[] args) {
        short[][] image = BWPicture.load("Baum.jpg");
        BWPicture.show(image, "Original");
        BWPicture.show(histImage(histogram(image), 200), "Histogramm");
    }
}