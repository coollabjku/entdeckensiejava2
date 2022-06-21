package Loesungen.Kapitel10;

// Aufgabe 28
public class CommaInserter {
    public static String insertComma(String text) {
        int pos = text.indexOf(" dass ");
        if (pos > 0 && text.charAt(pos - 1) != ',') {
            text = text.substring(0, pos) + ',' + text.substring(pos);
        }
        return text;
    }

    public static void main(String[] args) {
        System.out.println(insertComma("Ich weiß, dass ich nichts dass weiß."));
        System.out.println(insertComma("Sein oder Nichtsein, das ist hier die Frage."));
        System.out.println(insertComma("Wetten, dass...?"));
        System.out.println(insertComma("Dass er die Prüfung nicht bestanden hatte, "
                + "hatte nichts damit zu tun, wie viel er gelernt hatte."));
    }
}