package Aufgaben.Kapitel8.Example;

import java.util.Scanner;

public class Translator {
    static char[][] translation = { { 'A', 0x410 }, { 'a', 0x430 }, { 'B', 0x411 }, { 'b', 0x431 }, { 'W', 0x412 },
            { 'w', 0x432 }, { 'G', 0x413 }, { 'g', 0x433 }, { 'D', 0x414 }, { 'd', 0x434 }, { 'E', 0x415 },
            { 'e', 0x435 }, { '1', 0x416 }, { '2', 0x436 }, { 'Z', 0x417 }, { 'z', 0x437 }, { 'I', 0x418 },
            { 'i', 0x438 }, { 'J', 0x419 }, { 'j', 0x439 }, { 'K', 0x41A }, { 'k', 0x43A }, { 'L', 0x41B },
            { 'l', 0x43B }, { 'M', 0x41C }, { 'm', 0x43C }, { 'N', 0x41D }, { 'n', 0x43D }, { 'O', 0x41E },
            { 'o', 0x43E }, { 'P', 0x41F }, { 'p', 0x43F }, { 'R', 0x420 }, { 'r', 0x440 }, { 'S', 0x421 },
            { 's', 0x441 }, { 'T', 0x422 }, { 't', 0x442 }, { 'U', 0x423 }, { 'u', 0x443 }, { 'F', 0x424 },
            { 'f', 0x444 }, { 'H', 0x425 }, { 'h', 0x445 }, { 'C', 0x426 }, { 'c', 0x446 }, { '3', 0x427 },
            { '4', 0x447 }, { '5', 0x428 }, { '6', 0x448 }, { '7', 0x429 }, { '8', 0x449 }, { '-', 0x44A },
            { 'Y', 0x42B }, { 'y', 0x44B }, { '_', 0x44C }, { '9', 0x42D }, { '0', 0x44D }, { 'Q', 0x42E },
            { 'q', 0x44E }, { 'X', 0x42F }, { 'x', 0x44F }, };

    public static void main(String[] args) {

        System.out.println("Bitte Satz eingeben: ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] lineArray = line.toCharArray();

        String ausgabe = "";
        for (int i = 0; i < lineArray.length; i++) {
            ausgabe += translate(lineArray[i]);
        }
        System.out.println(ausgabe);

        System.out.println("Der Satz wurde erfolgreich umgesetzt.");
    }

    public static char translate(char x) {
        int i = 0;
        char tmp = ' ';

        while (tmp == ' ' && i < translation.length) {
            if (x == translation[i][0]) {
                tmp = translation[i][1];
            } else {
                i++;
            }
        }
        return tmp;
    }
}
