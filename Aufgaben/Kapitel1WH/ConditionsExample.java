package Aufgaben.Kapitel1WH;

import java.util.Scanner;

public class ConditionsExample {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bitte den Tag eingeben: ");
        int day = sc.nextInt();
        if (day < 1 || day > 31) {
            System.out.println("Kein gueltiges Datum fuer den Monat Dezember.");
        } else {
            switch (day) {
                case 8:
                    System.out.println("Feiertag: Maria Empfaengnis.");
                    break;
                case 24:
                    System.out.println("Weihnachten, aber kein Feiertag");
                    break;
                case 25:
                    System.out.println("Feiertag: Christtag.");
                    break;
                case 26:
                    System.out.println("Feiertag: Stephanitag.");
                    break;
                case 31:
                    System.out.println("Silvester, aber kein Feiertag.");
                    break;
                default:
                    System.out.println("Leider kein Feiertag :(.");
            }
        }
    }
}