package Loesungen.Kapitel24_A5Z;

public class Fish implements Movement {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println("Der Fisch " + this.getName() + " schwimmt im Meer.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Fish fisch1 = new Fish("Dora");
        fisch1.move();
    }
}