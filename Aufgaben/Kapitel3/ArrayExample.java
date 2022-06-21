package Aufgaben.Kapitel3;

import java.util.Scanner;

public class ArrayExample {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] inventory = new String[] { "brot", "nudel", "milch", "kaffee", "zucker" };
        String searchTerm = "";

        System.out.println("Bitte Lebensmittel eingeben: ");
        searchTerm = sc.next();
        int i;
        for (i = 0; i < inventory.length; i++) {
            if (searchTerm.equalsIgnoreCase(inventory[i])) {
                System.out.println("Lebensmittel ist im Supermarkt lagernd.");
                break;
            }
        }

        if (i == inventory.length) {
            System.out.println("Lebensmittel leider nicht lagernd.");
        }
    }

}
