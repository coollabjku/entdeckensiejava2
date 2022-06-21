package Loesungen.Kapitel7;

// Aufgabe 19
public class ImageEdgeFilter {
    public static short[][] edgeFilter(short[][] image, int delta) {
        short[][] newImage = new short[image.length][image[0].length];
        for (int i = 0; i < image.length - 1; i++) {
            for (int j = 0; j < image[0].length - 1; j++) {
                int currentVal = image[i][j];
                int rightVal = image[i][j + 1];
                int downVal = image[i + 1][j];
                if (Math.abs(currentVal - rightVal) >= delta || Math.abs(currentVal - downVal) >= delta) {
                    newImage[i][j] = 255;
                }
            }
        }
        return newImage;
    }

    public static void main(String[] args) {
        short[][] image = BWPicture.load("Baum.jpg");
        BWPicture.show(image, "Original");
        BWPicture.show(edgeFilter(image, 20), "delta=20");
    }
}