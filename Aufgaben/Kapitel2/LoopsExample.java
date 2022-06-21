package Aufgaben.Kapitel2;

import java.util.Scanner;

public class LoopsExample {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        do {
            System.out.print("Bitte " + (i + 1) + ". Zahl eingeben: ");
            sum += sc.nextInt();
            i++;
        } while (i < 5);
        System.out.println("1. Zwischensumme: " + sum);

        i = 0;
        while (i < 5) {
            System.out.print("Bitte " + (i + 1) + ". Zahl eingeben: ");
            sum += sc.nextInt();
            i++;
        }
        System.out.println("2. Zwischensumme: " + sum);

        for (i = 0; i < 5; i++) {
            System.out.print("Bitte " + (i + 1) + ". Zahl eingeben: ");
            sum += sc.nextInt();
        }
        System.out.println("Endsumme 3: " + sum);
    }

}
