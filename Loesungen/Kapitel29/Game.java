package Loesungen.Kapitel29;

// Aufgabe 66
public class Game extends Product {
    private int ageRating;

    public Game(String name, double price, int amount, int productID, int ageRating) {
        super(name, price, amount, productID);
        this.ageRating = ageRating;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }
}