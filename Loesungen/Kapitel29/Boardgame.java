package Loesungen.Kapitel29;

// Aufgabe 66
public class Boardgame extends Game implements Playable {
    public Boardgame(String name, double price, int amount, int productID, int ageRating) {
        super(name, price, amount, productID, ageRating);
    }

    @Override
    public void play(int playerCount) {
        System.out.print(getName() + ": ");
        if (playerCount <= 4) {
            System.out.println("Viel Spass!");
        } else {
            System.out.println("Ist nur bis max. 4 Personen spielbar");
        }
    }
}
