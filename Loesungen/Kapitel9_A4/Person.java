package Loesungen.Kapitel9_A4;

// Aufgabe 26
public class Person {
    private String firstName;
    private String lastName;
    private Person mother;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private Person(String firstName) {
        this.firstName = firstName;
        this.lastName = "";
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getMother() {
        if (mother == null) {
            mother = new Person("Eva");
        }
        return mother;
    }
}