package Loesungen.Kapitel10;

// Aufgabe 29
public class DuplicateWordRemover {
    public static String removeDuplicateWords(String text) {
        String[] words = text.split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i < words.length - 1 && words[i].equals(words[i + 1])) {
                continue;
            }
            sb.append(words[i] + ' ');
        }
        return sb.toString();
    }

    public static String removeDuplicateWords2(String text) {
        String[] words = text.split(" +");
        StringBuilder sb = new StringBuilder();
        String prevWord = null;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(prevWord)) {
                sb.append(words[i] + ' ');
            }
            prevWord = words[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateWords("Auge um Auge - und und die ganze Welt wird blind sein."));
        System.out.println(removeDuplicateWords("Hoffnung ist ein gutes Frühstück aber ein schlechtes Abendbrot Abendbrot"));
        System.out.println(removeDuplicateWords("Reden Reden lernt man durch reden – programmieren durch programmieren"));
    }
}
