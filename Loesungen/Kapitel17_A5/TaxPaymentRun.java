package Loesungen.Kapitel17_A5;

/**
 * A test program to test the implementation of the {@link HonestResident},
 * {@link DishonestResident} and {@link ResidentWithChildren} classes.
 * 
 * @author ESOP Team 2012
 * 
 */
public class TaxPaymentRun {

	public static void main(String[] args) {
		HonestResident h1 = new HonestResident();
		h1.earnMoney(100);
		System.out.println("Honest: " + h1.getDeclaredEarnings());
		h1.payTax();
		System.out.println("Honest: " + h1.getDeclaredEarnings());

		DishonestResident d1 = new DishonestResident();
		d1.earnMoney(100);
		System.out.println("Dishonest: " + d1.getDeclaredEarnings());
		d1.payTax();
		System.out.println("Dishonest: " + d1.getDeclaredEarnings());
		d1.earnMoney(100);
		System.out.println("Dishonest: " + d1.getDeclaredEarnings());
		d1.payTax();
		System.out.println("Dishonest: " + d1.getDeclaredEarnings());

		ResidentWithChildren c1 = new ResidentWithChildren(1);
		c1.earnMoney(100);
		System.out.println("Resident w. children (1): " + c1.getDeclaredEarnings());
		c1.payTax();
		System.out.println("Resident w. children (1): " + c1.getDeclaredEarnings());

		ResidentWithChildren c2 = new ResidentWithChildren(2);
		c2.earnMoney(100);
		System.out.println("Resident w. children (2): " + c2.getDeclaredEarnings());
		c2.payTax();
		System.out.println("Resident w. children (2): " + c2.getDeclaredEarnings());
	}

}
