package Loesungen.Kapitel1WH;

import java.util.Scanner;

// Aufgabe 2
public class Partyservice {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Wie viele Leute kommen zu Ihrer Party?: ");
        int personAmount = sc.nextInt();

        if (personAmount > 340) {
            System.out.println("Dieser Partyservice kann maximal fuer 340 Personen liefern");
        } else if (personAmount <= 0) {
            System.out.println("Ihre Party ist gratis. Juhu!");
        } else {
            double price = 0.0;
            System.out.print("In welchem Monat findet die Party statt (1-12)? ");
            int monat = sc.nextInt();

            if (personAmount < 20) {
                price = 500;
            } else if (personAmount < 100) {
                price = 4000;
            } else if (personAmount < 340) {
                price = 12000;
            }

            if (monat == 7) {
                price = price * 1.1;
            } else if (monat == 8) {
                price = price * 1.15;
            } else if (monat == 11) {
                price = price * 0.88;
            } else if (monat == 12) {
                price = price * 0.82;
            }

            System.out.println("Diese Party kostet : " + price + " Euro.");
        }

    }

}
