package Loesungen.Kapitel13;

import java.io.*;

// Aufgabe 38
public class GapTextGeneratorArticles {
    public static String gapText(String text) {
        String s = " __ ";
        text = text.replace(" il ", s).replace(" la ", s).replace(" l ", s).replace(" l'", s).replace(" i ", s)
                .replace(" gli ", s).replace(" le ", s);
        return text;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/blatt_4/italiano.txt"));
        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            sb.append(br.readLine() + "\n");
        }
        System.out.println(gapText(sb.toString()));
        br.close();
    }
}