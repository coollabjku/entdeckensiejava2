package Loesungen.Kapitel18;

/**
 * A test program to test the implementation of the {@link Employee} and
 * {@link Employer} classes.
 * 
 * @author ESOP Team 2012
 * 
 */
public class EmploymentRun {
	public static void main(String[] args) {
		Employer e1 = new Employer("Sara", "Kneeskern");
		Employer e2 = new Employer("Hugo", "Plant");
		System.out.println(e1);
		System.out.println(e2);

		System.out.println(e1 + " is hiring");
		Employee emp1 = new Employee("David", "Magee");
		e1.employ(emp1);
		Employee emp2 = new Employee("Richard", "Richmond");
		e1.employ(emp2);
		Employee emp3 = new Employee("Frank", "Lampert");
		e1.employ(emp3);
		Employee emp4 = new Employee("Jill", "Mayrs");
		e1.employ(emp4);
		Employee emp5 = new Employee("Gail", "Richardson");
		e1.employ(emp5);
		Employee emp6 = new Employee("Jeff", "Armstrong");
		e1.employ(emp6);
		Employee emp7 = new Employee("Lori", "Merk");
		e1.employ(emp7);

		System.out.println(e1 + " stops hiring");
		e1.printEmployees();

		System.out.println(e2 + " is hiring");
		Employee emp8 = new Employee("Sandy", "Stout");
		e2.employ(emp8);
		e2.employ(emp1);
		System.out.println(e2 + " stops hiring");
		e2.printEmployees();
		e1.printEmployees();
	}
}
