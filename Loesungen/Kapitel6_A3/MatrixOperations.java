package Loesungen.Kapitel6_A3;

public class MatrixOperations {

    public static void main(String[] args) {
        // Aufgabe 16
        int[][] m = randMatrix(4, 5, 100);

        printMatrix(m);
        m = transpose(m);
        System.out.println("\n\nTransponded one:");
        printMatrix(m);

    }

    // Aufgabe 13
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    // Aufgabe 14
    public static int[][] transpose(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    // Aufgabe 15
    public static int[][] randMatrix(int m, int n, int z) {
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (int) (Math.random() * z) + 1;
            }
        }

        return matrix;
    }
}