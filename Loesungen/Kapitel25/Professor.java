package Loesungen.Kapitel25;

// Aufgabe 60
public class Professor extends Person {

    private double salary;

    public Professor(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
