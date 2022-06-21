package Aufgaben.Kapitel17_A5;

/**
 * Represents an honest resident in country Taxing.
 * 
 * @author ESOP Team 2012
 * 
 */
public class HonestResident implements Taxpayer {
	private float declaredEarnings;

	/**
	 * Constructs and initializes an honest resident.
	 */
	public HonestResident() {
		declaredEarnings = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see teil1.Taxpayer#earnMoney(float)
	 */
	public void earnMoney(float amount) {
		declaredEarnings = declaredEarnings + amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see teil1.Taxpayer#getDeclaredEarnings()
	 */
	public float getDeclaredEarnings() {
		return declaredEarnings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see teil1.Taxpayer#payTax()
	 */
	public float payTax() {
		float tax = declaredEarnings * 0.2f;
		declaredEarnings = declaredEarnings * 0.8f;
		return tax;
	}
}
