package Aufgaben.Kapitel7;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Hilfsklasse zum Laden und Anzeigen von Schwarzweißbildern.
 * 
 * Die Bilder werden als 2D-Array short[z][s] verarbeitet, wobei der Eintrag z/s
 * (Zeile/Spalte) den Grauwert des Pixels z/s angibt (0..255=0xff).
 * 
 * Version 1.0, 17. Juni 2011, MH. Version 1.1, 25. Juli 2011, MT.
 * 
 * @author Martin Hitz
 * @author Mario Taschwer
 */
public class BWPicture {

    /**
     * S/W-Bild (im JPG-Format) aus Datei laden.
     * 
     * @param imageFileName Dateiname des Bildes.
     * @return Bild als 2D-Array.
     */
    public static short[][] load(String imageFileName) {
        BufferedImage img = null;

        try {
            File input = new File(imageFileName);
            img = ImageIO.read(input);
        } catch (IOException ie) {
            System.out.println("Fehler beim Lesen der Datei:" + ie.getMessage());
            return null;
        }

        int imgCols = img.getWidth();
        int imgRows = img.getHeight();

        System.out.println(imageFileName + ": " + imgCols + " " + imgRows);

        int[] oneDPix = new int[imgCols * imgRows];

        PixelGrabber pg = new PixelGrabber(img, 0, 0, imgCols, imgRows, oneDPix, 0, imgCols);

        boolean error = false;
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            error = true;
        }
        if (error || (pg.getStatus() & ImageObserver.ABORT) != 0) {
            System.err.println("Pixelextraktion gescheitert!");
            System.exit(1);
        }

        return convertTo2D(oneDPix, imgRows, imgCols);
    }

    /** Anzahl der aktiven Bildfenster. */
    private static int pictureCount = 0;

    /**
     * Zeigt ein S/W-Bild in einem neuen Fenster an. Wenn alle aktiven Fenster vom
     * Benutzer geschlossen werden, wird die Anwendung mittels
     * {@link System#exit(int)} beendet.
     * 
     * @param image das anzuzeigende Bild als 2D-Array.
     * @param title der Titel des Bildfensters (wird in der Titelleiste angezeigt).
     * @return eine eindeutige Nummer des Bildfensters.
     */
    @SuppressWarnings("serial")
    public static int show(short[][] image, String title) {
        int width = image[0].length;
        int height = image.length;
        ++pictureCount;

        JFrame window = new JFrame(title);

        final Image img = window.createImage(new MemoryImageSource(width, height, convertTo1D(image), 0, width));
        window.add(new Canvas() {
            public void paint(Graphics g) {
                g.drawImage(img, 0, 0, this);
            }
        });
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (--pictureCount == 0)
                    System.exit(0);
            }
        });

        window.setSize(width, height);
        window.setLocation(20 * pictureCount, 20 * pictureCount);
        window.setVisible(true);

        return pictureCount;
    }

    /**
     * Konvertiert ein S/W-Bild vom 2D-Format ins 1D-Format. Die Pixel werden dabei
     * zeilenweise hintereinander gespeichert.
     * 
     * @param image Bild im 2D-Format, das konvertiert werden soll.
     * @return die 1D-Darstellung des Bildes.
     */
    private static int[] convertTo1D(short[][] image) {
        int imgRows = image.length;
        int imgCols = image[0].length;
        int[] oneDPix = new int[imgCols * imgRows];

        for (int row = 0, cnt = 0; row < imgRows; row++) {
            for (int col = 0; col < imgCols; col++) {
                oneDPix[cnt] = 0xff000000 | ((image[row][col] << 16) & 0x00FF0000)
                        | ((image[row][col] << 8) & 0x0000FF00) | (image[row][col] & 0x000000FF);

                cnt++;
            }
        }
        return oneDPix;
    }

    /**
     * Konvertiert ein S/W-Bild vom 1D-Format ins 2D-Format.
     * 
     * @param oneDPix Bild im 1D-Format.
     * @param imgRows Bildhöhe in Pixel.
     * @param imgCols Bildbreite in Pixel.
     * @return die 2D-Darstellung des Bildes.
     */
    private static short[][] convertTo2D(int[] oneDPix, int imgRows, int imgCols) {
        short[][] image = new short[imgRows][imgCols];

        for (int i = 0; i < imgRows; i++)
            for (int j = 0; j < imgCols; j++)
                image[i][j] = (short) ((oneDPix[i * imgCols + j]) & 0x000000ff);
        return image;
    }
}