package Aufgaben.Kapitel12_A4Z;

public class StringExample {
    public static void main(String[] args) {
        String sentence1 = "Hallo. Ich bin der erste Satz. Man nennt mich auch String;";
        String sentence2 = "Hier gibt es einen 2. Satz, der ebenfalls ein String ist;";

        System.out.println();

        System.out.println("8. Zeichen im 1. String: " + sentence1.charAt(7));

        for (int i = 32; i < sentence2.length(); i++) {
            System.out.print(sentence2.charAt(i));
        }
        String word1 = "ebenfalls";
        String word2 = "EbEnFaLlS";
        System.out.println("\n");
        System.out.println("Compare gibt an, dass die Strings ungleich sind: " + word1.compareTo(word2));
        System.out.println("Bei Rückgabewert 0 sind die Strings gleich, da Gross/Kleinschreibung ignoriert wird: "
                + word1.compareToIgnoreCase(word2) + "\n");
        System.out.println("Equals gibt einen Boolean zurueck: " + word1.equals(word2));
        System.out.println("Equals gibt einen Boolean zurueck, ignoriert Gross/Kleinschreibung: "
                + word1.equalsIgnoreCase(word2) + "\n");
        System.out.println("Gibt an, an welchem Index 'S' zuerst vorkommt: " + sentence1.indexOf("S"));
        System.out.println("Äquivalent zu indexOf, nur dass der letzte Index angegeben wird, an dem ein 'S' vorkommt: "
                + sentence1.lastIndexOf("S") + "\n");
        System.out.println("Gibt an, an welchem Index der Substring 'gibt es ein' zuerst vorkommt: "
                + sentence2.indexOf("gibt es ein"));
        System.out.println(
                "Gibt an, an welchem Index das word1 ab der Stelle 10 vorkommt: " + sentence2.indexOf(word1, 9) + "\n");

        String newString = sentence1.replace('a', 'f');
        System.out.println("Replace ersetzt ein char (a) mit einem anderen char(f): " + newString);
        newString = sentence2.replaceAll(word1, word2);
        System.out.println("Und replaceAll ersetzt den 1. Substring mit dem 2. Substring: " + newString + "\n");
        String[] stringArray = sentence1.split(" ");
        System.out.println("Der sentence1 wurde nun in ein Array unterteilt, mit dem Trennzeichen ' ': "
                + stringArray[0] + " " + stringArray[5] + "\n");
        newString = sentence1.substring(7, 30);
        System.out.println("Der Substring vom sentence1 vom Index 7 - 30: " + newString + "\n");
        char[] charArray = sentence2.toCharArray();
        System.out.println("Erstellt ein char Array vom sentence2: " + charArray[3] + " " + charArray[19] + "\n");
        System.out.println("Wandelt alle Grossbuchstaben in Kleinbuchstaben um: " + word2.toLowerCase());
        System.out.println("Wandelt alle Kleinbuchstaben in Grossbuchstaben um: " + word2.toUpperCase());
    }
}