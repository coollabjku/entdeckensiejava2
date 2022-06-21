package Loesungen.Kapitel24_A5Z;

// Aufgabe 57
public class Sheep extends Mammal implements Movement {
    private String color;

    public Sheep(int size, String sound, String color) {
        super(size, sound, "Lamm");
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void move() {
        System.out.println("Das Lamm grast.");
    }

    public static void main(String[] args) {
        Sheep lamb = new Sheep(200, "bäääääääähhhh", "schwarz");
        lamb.communicate();
        System.out.println("Auf der Weide ist ein " + lamb.getColor() + " Lamm.");
    }
}