package Loesungen.Kapitel7;

// Aufgabe 18
public class ImageMirror {
    public static short[][] flipH(short[][] image) {
        short[][] newImage = emptyArray(image);
        int width = image[0].length;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < width; j++) {
                newImage[i][j] = image[i][width - 1 - j];
            }
        }
        return newImage;
    }

    public static short[][] flipV(short[][] image) {
        short[][] newImage = emptyArray(image);
        int height = image.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < image[0].length; j++) {
                newImage[i][j] = image[height - 1 - i][j];
            }
        }
        return newImage;
    }

    public static short[][] emptyArray(short[][] a) {
        return new short[a.length][a[0].length];
    }

    public static void main(String[] args) {
        short[][] image = BWPicture.load("Baum.jpg");
        BWPicture.show(image, "Original");
        BWPicture.show(flipH(image), "Flip horizontal");
        BWPicture.show(flipV(image), "Flip vertikal");
    }
}