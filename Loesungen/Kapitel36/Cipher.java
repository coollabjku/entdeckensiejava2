package Loesungen.Kapitel36;

// Aufgabe 78
public interface Cipher {
    public String encrypt(String cleartext) throws IllegalArgumentException;

    public String decrypt(String encryptedtext) throws IllegalArgumentException;
}
