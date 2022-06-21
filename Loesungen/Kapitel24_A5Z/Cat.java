package Loesungen.Kapitel24_A5Z;

public class Cat extends Animal implements Pet {
    private boolean purring;

    public Cat(String name, int age, boolean purring) {
        super(name, age);
        this.purring = purring;
    }

    public boolean isPurring() {
        return purring;
    }

    public void setPurring(boolean purring) {
        this.purring = purring;
    }

    @Override
    public void pet() {
        if (this.purring) {
            System.out.println(this.getName() + " schnurrrrrt");
        } else {
            System.out.println(this.getName() + " pfaucht und laeuft davon");
        }
    }
}