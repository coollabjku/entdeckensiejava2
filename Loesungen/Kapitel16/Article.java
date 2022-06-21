package Loesungen.Kapitel16;

// Aufgabe 47
public class Article {
    private String name;
    private double price;

    public Article(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return price;
    }

    public void setPreis(double price) {
        this.price = price;
    }
}