package Loesungen.Kapitel3;

import java.util.Scanner;

// Aufgabe 6
public class OneDimensionalArray {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers1 = { 12, 23, 45, 67, 55, 77, 89, 99, 43, 22 };
        int[] numbers2 = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Geben Sie Zahl " + (i + 1) + " von 10 ein: ");
            numbers2[i] = sc.nextInt();
        }

        int[] average = new int[10];
        int found = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (numbers1[i] == numbers2[j]) {
                    average[found++] = numbers1[i];
                }
            }
        }

        for (int i = 0; i < found; i++) {
            System.out.print(average[i] + " ");
        }

        System.out.println();
    }

}