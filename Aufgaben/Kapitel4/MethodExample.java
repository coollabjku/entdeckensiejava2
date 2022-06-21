package Aufgaben.Kapitel4;

import java.util.Scanner;

public class MethodExample {
    static Scanner sc = new Scanner(System.in);

    static String[] inventory = new String[] { "brot", "nudel", "milch", "kaffee", "zucker" };

    public static void main(String[] args) {
        String searchTerm = "";
        System.out.println("Bitte Lebensmittel eingeben: ");
        searchTerm = sc.next();
        String result = searchInventory(searchTerm);
        System.out.println(result);
    }

    public static String searchInventory(String searchTerm) {
        String s = "Lebensmittel ist nicht lagernd.";
        for (int i = 0; i < inventory.length; i++) {
            if (searchTerm.equalsIgnoreCase(inventory[i])) {
                s = "Lebensmittel ist im Supermarkt lagernd.";
                break;
            }
        }
        return s;
    }
}