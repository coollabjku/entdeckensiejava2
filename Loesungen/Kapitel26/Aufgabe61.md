In die Klasse Auto haben sich ein paar Fehler eingeschlichen. Versuchen Sie alle 8 Fehler zu finden! (Die Klasse Auto erbt von der Klasse Fahrzeug, die Sie direkt unter der Klasse Auto finden).

```Java
public class Auto implements Fahrzeug { // F1: extends
    private double preis = true; // F2: preis ist double, nicht boolean

    public Auto(String marke, char[] farbe, double preis) { // F3: 2.
        // Parameter muss String sein
        super(farbe, marke); // F4: Variablen vertauscht
        preis = this.preis; // F5: this.preis = preis
    }

    public String toString() {
        return this.setMarke() + "\t" + this.setFarbe() + "\t" + this.preis; // F6, F7: set-Methoden sind falsch
    }

    public static void main(String[] args) {
        System.out.println("Marke" + "\t" + "Farbe" + "\t" + "Preis");
        Auto audi = new Fahrzeug("Audi", "schwarz", 40000);
        // F8: der Konstruktor von Fahrzeug hat 2 nur Parameter
        System.out.println(audi.toString());
        Fahrzeug bmw = new Auto("BMW", "weiss", 35000);
        System.out.println(bmw);
    }
}
```

```Java
public class Fahrzeug {
    private String marke;
    private String farbe;

    public Fahrzeug(String marke, String farbe) {
        this.marke = marke;
        this.farbe = farbe;
    }

    public String getMarke() {
        return marke;
    }

    public String getFarbe() {
        return farbe;
    }
}
```