package Aufgaben.Kapitel30_A6;

import java.util.Scanner;

// Aufgabe 67
public class TextSortRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextSorter ts = new TextSorter();
        System.out.println("Text oder Command (L)ist | (S)ort | (E)xit " + "eingeben");
        while (true) {
            System.out.print("> ");
            String s = sc.nextLine();
            switch (s.toLowerCase()) {
                case "":
                    break;
                case "l":
                    ts.listContent();
                    break;
                case "s":
                    ts.sortContent();
                    break;
                case "e":
                    sc.close();
                    System.exit(0);
                default:
                    ts.addText(s);
                    break;
            }
        }
    }
}
