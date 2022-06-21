package Loesungen.Kapitel14.Example;

public class Dog {
    private String name;
    private static final String sound = "bark";

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String makeSound() {
        return sound;
    }
}
