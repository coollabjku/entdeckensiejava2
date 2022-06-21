package Aufgaben.Kapitel8;

import java.io.*;
import java.util.*;

// Aufgabe 25
public class Dictionary {
    // Load in the dictionary
    private List<String[]> dict;
    private String[] languages;

    public Dictionary() throws IOException {
        dict = new ArrayList<String[]>();
        BufferedReader br = new BufferedReader(new FileReader("Familie.txt"));
        languages = br.readLine().split("\t");
        while (br.ready()) {
            String[] sa = br.readLine().split("\t");
            if (sa.length == languages.length) {
                dict.add(sa);
            }
        }
        br.close();
    }

    // TODO: Your code here
}