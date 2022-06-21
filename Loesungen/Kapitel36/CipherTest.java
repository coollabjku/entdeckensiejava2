package Loesungen.Kapitel36;

public class CipherTest {
    public static void main(String[] args) {
        String text = "Hello Cipher";
        // String text = "";
        // String text = null;
        Cipher rc = new ReverseCipher();

        // Aufgabe 78
        try {
            String cipher1 = rc.encrypt(text);
            System.out.println(text + " is reverse encrypted: " + cipher1);
            System.out.println(cipher1 + " is reverse decrypted: " + rc.decrypt(cipher1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Cipher cc = new CaesarCipher(3);
        try {
            String cipher2 = cc.encrypt(text);
            System.out.println(text + " is caesar encrypted: " + cipher2);
            System.out.println(cipher2 + " is caesar decrypted: " + cc.decrypt(cipher2));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}