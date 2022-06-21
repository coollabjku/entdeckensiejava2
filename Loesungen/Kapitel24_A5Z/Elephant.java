package Loesungen.Kapitel24_A5Z;

// Aufgabe 57
public class Elephant extends Mammal implements Movement {
    private int weight;

    public Elephant(int size, String sound, int weight) {
        super(size, sound, "Elefant");
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int kg) {
        this.weight = kg;
    }

    @Override
    public void move() {
        System.out.println("Der Elefant trampelt.");
    }

    public static void main(String[] args) {
        Elephant elephant = new Elephant(200, "töröööööö", 4500);
        elephant.communicate();
        System.out.println("Der Elefant ist " + elephant.getWeight() + " kg schwer.");
    }
}