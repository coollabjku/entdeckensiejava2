package Loesungen.Kapitel31;

public class Employee extends Person {
    private int nrOfEmployments;

    public Employee(String givenName, String familyName) {
        super(givenName, familyName);
        nrOfEmployments = 0;
    }

    public void addEmployment() {
        nrOfEmployments++;
    }

    public int getNrOfEmployments() {
        return nrOfEmployments;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + nrOfEmployments + ")";
    }
}
