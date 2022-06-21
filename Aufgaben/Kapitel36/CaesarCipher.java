package Aufgaben.Kapitel36;

public class CaesarCipher implements Cipher {
    private int key;

    public CaesarCipher(int key) {
        this.key = key;
    }

    @Override
    public String encrypt(String s) throws IllegalArgumentException {
        // Aufgabe 78
        // TODO: Implement throwing the IllegalArgumentException here
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toUpperCase().toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                ch += key;
                if (ch > 'Z') {
                    ch -= 26;
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String s) throws IllegalArgumentException {
        // Aufgabe 78
        // TODO: Implement throwing the IllegalArgumentException here
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toUpperCase().toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                ch -= key;
                if (ch < 'A') {
                    ch += 26;
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}