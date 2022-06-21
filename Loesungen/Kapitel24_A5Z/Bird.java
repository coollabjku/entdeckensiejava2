package Loesungen.Kapitel24_A5Z;

public class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println("Der Vogel " + this.getName() + " fliegt durch die Luefte.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Bird vogel1 = new Bird("Tweety");
        vogel1.move();
    }
}
