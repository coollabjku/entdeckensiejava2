package Aufgaben.Kapitel24_A5Z;

public class Dog extends Animal implements Pet {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void apport(String item) {
        System.out.println(this.getName() + " apportiert " + item);
    }

    @Override
    public void pet() {
        System.out.println(this.getName() + " legt sich auf den Ruecken und wedelt mit dem Schwanz");
    }
}