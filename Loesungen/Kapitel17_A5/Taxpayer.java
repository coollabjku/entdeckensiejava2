package Loesungen.Kapitel17_A5;

/**
 * The interface that all resident classes must implement.
 * 
 * @author ESOP Team 2012
 * 
 */
public interface Taxpayer {
	/**
	 * Invoked when a resident earns money.
	 * 
	 * @param amount the amount of money earned
	 */
	public void earnMoney(float amount);

	/**
	 * Returns the amount of declared earnings.
	 * 
	 * @return the declared earnings
	 */
	public float getDeclaredEarnings();

	/**
	 * Is invoked when a resident has to pay tax.
	 * 
	 * @return the amount of payed tax
	 */
	public float payTax();
}
