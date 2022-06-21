package Aufgaben.Kapitel3;

public class MatrixExample {
    public static void main(String[] args) {
        // Zeile 1: Kapazitaet, Zeile 2: Belegung
        // Spalte 1: Zimmer 1, Spalte 2: Zimmer 2...
        int[][] rooms = new int[][] { { 4, 8, 4, 3, 5, 7 }, { 2, 0, 4, 3, 1, 5 } };
        for (int j = 0; j < rooms[0].length; j++) {
            System.out.println("Das " + (j + 1) + ". Zimmer hat " + rooms[0][j] + " Plaetze" + " und davon sind "
                    + rooms[1][j] + " belegt.");
        }
    }
}
