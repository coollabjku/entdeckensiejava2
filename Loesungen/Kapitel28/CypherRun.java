package Loesungen.Kapitel28;

// Aufgabe 17
public class CypherRun {
    public static void main(String[] args) {
        ReverseCipher rc = new ReverseCipher();
        String text = "Hello Cipher";

        String cipher1 = rc.encrypt(text);
        System.out.println(text + " is reverse encrypted: " + cipher1);
        System.out.println(cipher1 + " is reverse decrypted: " + rc.decrypt(cipher1));

        System.out.println();

        CaesarCipher cc = new CaesarCipher(4);
        String cipher2 = cc.encrypt(text);
        System.out.println(text + " is caesar encrypted: " + cipher2);
        System.out.println(cipher2 + " is caesar decrypted: " + cc.decrypt(cipher2));
    }
}