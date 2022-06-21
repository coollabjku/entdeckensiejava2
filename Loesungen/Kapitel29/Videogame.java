package Loesungen.Kapitel29;

// Aufgabe 66
public class Videogame extends Game implements Playable {
    public Videogame(String name, double price, int amount, int productID, int ageRating) {
        super(name, price, amount, productID, ageRating);
    }

    @Override
    public void play(int playerCount) {
        System.out.print(getName() + ": ");
        if (playerCount > 2) {
            System.out.println("Spiele im Onlinemodus");
        } else {
            System.out.println("Spiele im Kooperationsmodus");
        }
    }
}