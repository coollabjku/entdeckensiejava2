package Loesungen.Kapitel25;

// Aufgabe 60
public class Student extends Person {

    private int matriculationNumber;
    private int ects;

    public Student(String name, int age, int matriculationNumber, int ects) {
        super(name, age);
        this.matriculationNumber = matriculationNumber;
        this.ects = ects;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
}