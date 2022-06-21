package Loesungen.Kapitel14.Example;

public class AnimalsRun {
    public static void main(String[] args) {
        Cat cat = new Cat("Garfield");
        Dog dog = new Dog("Timo");
        System.out.println("Der Hund " + dog.getName() + " macht " + dog.makeSound());
        System.out.println("Die Katze " + cat.getName() + " ist " + cat.getAge() + " Jahre alt.");
    }
}