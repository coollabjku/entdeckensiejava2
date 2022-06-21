package Loesungen.Kapitel31;

import java.util.ArrayList;

// Aufgabe 69
public class EmployerUnlimited extends Person implements Employing {
    private ArrayList<Employee> employees;

    public EmployerUnlimited(String givenName, String familyName) {
        super(givenName, familyName);
        employees = new ArrayList<>();
    }

    public boolean employ(Employee employee) {
        employees.add(employee);
        employee.addEmployment();
        return true;
    }

    public int getNrOfEmployees() {
        return employees.size();
    }

    public void printEmployees() {
        System.out.println(this.getGivenName() + " " + this.getFamilyName() + "'s employees:");
        for (Employee e : employees) {
            System.out.println("  " + e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (" + employees.size() + ")";
    }
}
