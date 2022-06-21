package Loesungen.Kapitel24_A5Z;

public class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

    public void roar() {
        System.out.println(this.getName() + ": ROOOAAAAR");
    }
}