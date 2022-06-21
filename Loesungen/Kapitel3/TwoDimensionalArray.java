package Loesungen.Kapitel3;

import java.util.Scanner;

// Aufgabe 8
public class TwoDimensionalArray {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Wie viele Geschenke moechten Sie eingeben?: ");
        int presentCount = sc.nextInt();

        String[][] presents = new String[presentCount][3];

        for (int i = 0; i < presentCount; i++) {
            System.out.print("Person " + (i + 1) + ": ");
            presents[i][0] = sc.next();

            System.out.print("Geschenk " + (i + 1) + ": ");
            presents[i][1] = sc.next();

            System.out.print("Preis " + (i + 1) + ": ");
            presents[i][2] = sc.next();
        }

        double price = 0.0;
        for (int i = 0; i < presentCount; i++) {
            System.out.println(presents[i][1] + " fuer " + presents[i][0] + " kostet " + presents[i][2]);
            price += Double.parseDouble(presents[i][2]);
        }

        System.out.println("Gesamtsumme: " + price);
    }
}