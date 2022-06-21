package Aufgaben.Kapitel36;

public class ReverseCipher implements Cipher {
    public ReverseCipher() {
    }

    @Override
    public String encrypt(String s) throws IllegalArgumentException {
        // Aufgabe 78
        // TODO: Implement throwing the IllegalArgumentException here
        return new StringBuilder(s).reverse().toString();
    }

    @Override
    public String decrypt(String s) throws IllegalArgumentException {
        // Aufgabe 78
        // TODO: Implement throwing the IllegalArgumentException here
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Kein Text vorhanden!");
        }
        return encrypt(s);
    }
}