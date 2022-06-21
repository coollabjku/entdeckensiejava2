In die Klasse Auto haben sich ein paar Fehler eingeschlichen. Versuchen Sie alle 8 Fehler zu finden! (Die Klasse Auto erbt von der Klasse Fahrzeug, die Sie direkt unter der Klasse Auto finden).

```Java
public class Auto implements Fahrzeug {
    private double preis = true;

    public Auto(String marke, char[] farbe, double preis) {

        super(farbe, marke);
        preis = this.preis;
    }

    public String toString() {
        return this.setMarke() + "\t" + this.setFarbe() + "\t" + this.preis;
    }

    public static void main(String[] args) {
        System.out.println("Marke" + "\t" + "Farbe" + "\t" + "Preis");
        Auto audi = new Fahrzeug("Audi", "schwarz", 40000);

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