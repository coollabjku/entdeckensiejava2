package Loesungen.Kapitel7;

// Aufgabe 20
public class ImageHistogram {
    public static int[] histogram(short[][] image) {
        int[] histArr = new int[256];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                short value = image[i][j];
                histArr[value]++;
            }
        }
        return histArr;
    }

    public static short[][] histImage(int h[], int displayHeight) {
        short[][] image = new short[displayHeight][256];
        // Ermitteln des größten Wertes von h[]
        // und Berechnen der Skalierung
        int maxCount = 0;
        for (int x = 0; x < h.length; x++) {
            if (h[x] > maxCount) {
                maxCount = h[x];
            }
        }
        double factor = (double) displayHeight / maxCount;
        for (int col = 0; col < image[0].length; col++) {
            int col_top = displayHeight - (int) (h[col] * factor);
            for (int row = 0; row < col_top; row++) {
                image[row][col] = 255;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        short[][] image = BWPicture.load("Baum.jpg");
        BWPicture.show(image, "Original");
        BWPicture.show(histImage(histogram(image), 200), "Histogramm");
    }
}