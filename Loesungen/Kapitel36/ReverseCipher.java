package Loesungen.Kapitel36;

public class ReverseCipher implements Cipher {
    public ReverseCipher() {
    }

    @Override
    public String encrypt(String s) throws IllegalArgumentException {
        // Aufgabe 78
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Kein Text vorhanden!");
        }
        return new StringBuilder(s).reverse().toString();
    }

    @Override
    public String decrypt(String s) throws IllegalArgumentException {
        // Aufgabe 78
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Kein Text vorhanden!");
        }
        return encrypt(s);
    }
}