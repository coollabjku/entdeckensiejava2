package Loesungen.Kapitel28;

// Aufgabe 65
public class ReverseCipher implements Cipher {
    public ReverseCipher() {
    }

    @Override // Variante 1
    public String encrypt(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Variante 2
    // @Override
    // public String encrypt(String s) {
    // StringBuilder sb = new StringBuilder();
    // char[] ca = s.toCharArray();
    // for (int i = s.length() - 1; i >= 0; i--) {
    // sb.append(ca[i]);
    // }
    // return sb.toString();
    // }

    @Override
    public String decrypt(String s) {
        return encrypt(s);
    }
}