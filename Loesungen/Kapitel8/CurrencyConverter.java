package Loesungen.Kapitel8;

import java.util.*;

// Aufgabe 24
public class CurrencyConverter {
    private final Map<String, Double> currMap;
    private final Scanner sc;
    private final String currencyInfo;

    public CurrencyConverter() {
        sc = new Scanner(System.in);
        currMap = new HashMap<String, Double>();
        currMap.put("EUR", 1.0);
        currMap.put("ATS", 0.0726728);
        currMap.put("DEM", 0.5112919);
        StringBuilder sb = new StringBuilder();
        for (String s : currMap.keySet()) {
            sb.append(s + " ");
        }
        currencyInfo = sb.toString().trim();
    }

    private void showDialog() {
        System.out.print("\nBetrag (0 zum Beenden)? ");
        double valFrom = 0.0;
        try {
            valFrom = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FEHLER: Keine numerische Eingabe!");
            return;
        }
        if (valFrom == 0.0) {
            System.exit(0);
        }
        System.out.printf("Umrechnen von [%s]? ", currencyInfo);
        String currFrom = sc.nextLine().toUpperCase();
        if (!currMap.containsKey(currFrom)) {
            System.out.println("FEHLER: Währung nicht gefunden!");
            return;
        }
        System.out.printf("Umrechnen nach [%s]? ", currencyInfo);
        String currTo = sc.nextLine().toUpperCase();
        if (!currMap.containsKey(currTo)) {
            System.out.println("FEHLER: Währung nicht gefunden!");
            return;
        }
        double valTo = convert(currFrom, currTo, valFrom);
        System.out.printf("%.2f %s sind %.2f %s.\n", valFrom, currFrom, valTo, currTo);
    }

    private double convert(String currFrom, String currTo, double valFrom) {
        return valFrom * currMap.get(currFrom) / currMap.get(currTo);
    }

    public static void main(String[] args) {
        CurrencyConverter o = new CurrencyConverter();
        while (true) {
            o.showDialog();
        }
    }
}
