package Loesungen.Kapitel4;

import java.util.Scanner;

// Aufgabe 10
public class Fireworks {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Wie viele Raketen wollen Sie kaufen?: ");
        int rockets = readData();

        System.out.print("Wie viel kostet eine Rakete?: ");
        int price = readData();

        double totalPrice = calculatePrice(rockets, price);

        printPrice(totalPrice);
    }

    public static int readData() {
        return sc.nextInt();
    }

    public static double calculatePrice(int amount, int price) {
        double result = amount * price;
        if (amount > 10) {
            result = result * 0.95;
        }
        return result;
    }

    public static void printPrice(double price) {
        System.out.println("Der Gesamtpreis betraget: " + price + " Euro.");
    }
}