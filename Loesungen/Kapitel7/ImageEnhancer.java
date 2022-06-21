package Loesungen.Kapitel7;

// Aufgabe 17
public class ImageEnhancer {
    public static short[][] enhance(short[][] image, double f) {
        short[][] newImage = new short[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                double val = image[i][j] * f;
                if (val > 255) {
                    val = 255;
                }
                newImage[i][j] = (short) val;
            }
        }
        return newImage;
    }

    public static void main(String[] args) {
        short[][] image = BWPicture.load("Baum.jpg");
        BWPicture.show(image, "Original");
        BWPicture.show(enhance(image, 1.8), "* 1.8");
    }
}