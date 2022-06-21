package Loesungen.Kapitel18;

/**
 * A simple representation of a Person.
 * 
 * @author ESOP Team 2012
 * 
 */
public class Person {
	private String givenName;
	private String familyName;
	private Person mother;

	/**
	 * Constructs and initializes a person having the specified given name and
	 * family name.
	 * 
	 * @param givenName  the given name
	 * @param familyName the family name
	 */
	public Person(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}

	/**
	 * Constructs and initializes a person having the specified given name.
	 * 
	 * @param givenName the given name
	 */
	public Person(String givenName) {
		this.givenName = givenName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = familyName == null ? "" : ", " + familyName;
		return givenName + s;
	}

	/**
	 * Sets the mother of this person.
	 * 
	 * @param p the Person who is the mother
	 */
	public void setMother(Person p) {
		mother = p;
	}

	/**
	 * Returns the mother of this person.
	 * 
	 * @return the mother
	 */
	public Person getMother() {
		if (mother == null) {
			mother = new Person("Eva");
		}
		return mother;
	}

	/**
	 * Returns the given name of this person.
	 * 
	 * @return the given name
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * Returns the family name of this person.
	 * 
	 * @return the family name
	 */
	public String getFamilyName() {
		return familyName;
	}

}
