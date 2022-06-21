package Aufgaben.Kapitel36;

public class CipherTest {
    public static void main(String[] args) {
        String text = "Hello Cipher";
        // String text = "";
        // String text = null;
        Cipher rc = new ReverseCipher();

        // Aufgabe 78
        // TODO: Edit this code to handle the thrown exception here
        String cipher1 = rc.encrypt(text);
        System.out.println(text + " is reverse encrypted: " + cipher1);
        System.out.println(cipher1 + " is reverse decrypted: " + rc.decrypt(cipher1));

        Cipher cc = new CaesarCipher(3);

        // TODO: Edit this code to handle the thrown exception here
        String cipher2 = cc.encrypt(text);
        System.out.println(text + " is caesar encrypted: " + cipher2);
        System.out.println(cipher2 + " is caesar decrypted: " + cc.decrypt(cipher2));
    }
}