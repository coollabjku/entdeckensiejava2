package Loesungen.Kapitel10;

// Aufgabe 30
public class Capitalizer {
    public static String capitalize1(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            sb.append(word);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String capitalize2(String text) {
        char[] ca = text.toCharArray();
        char prevChar = ' ';
        for (int i = 0; i < ca.length; i++) {
            if (Character.isWhitespace(prevChar)) {
                ca[i] = Character.toUpperCase(ca[i]);
            }
            prevChar = ca[i];
        }
        return String.valueOf(ca);
    }

    public static void main(String[] args) {
        String s = "Heute muss Donnerstag sein. Mit Donnerstag kam ich noch nie zu Rande.";
        System.out.println(capitalize1(s));
        System.out.println(capitalize2(s));
    }
}