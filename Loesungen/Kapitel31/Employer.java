package Loesungen.Kapitel31;

// Aufgabe 69
public class Employer extends Person implements Employing {
    private int nrOfEmployees;
    private Employee[] employees;

    public Employer(String givenName, String familyName) {
        super(givenName, familyName);
        employees = new Employee[5];
    }

    public boolean employ(Employee employee) {
        if (nrOfEmployees >= 5) {
            System.out.println("!!! " + this + " cannot hire more!: [" + employee + "] !!!");
            return false;
        }
        employees[nrOfEmployees] = employee;
        employee.addEmployment();
        nrOfEmployees++;
        return true;
    }

    public int getNrOfEmployees() {
        return nrOfEmployees;
    }

    public void printEmployees() {
        System.out.println(this.getGivenName() + " " + this.getFamilyName() + "'s employees:");
        for (int i = 0; i < nrOfEmployees; i++) {
            System.out.println("  " + employees[i]);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (" + nrOfEmployees + ")";
    }
}
