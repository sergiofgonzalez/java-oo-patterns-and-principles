package org.joolzminer.examples.domain;

public class Person {
	private final String firstName;
	private final String lastName;
	private final String middleName;
	private final String salutation;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = null;
		this.salutation = null;
	}
	
	public Person(String firstName, String lastName, String middleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.salutation = null;
	}

	public Person(String firstName, String lastName, String middleName, String salutation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.salutation = salutation;
	}
	
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", salutation=" + salutation + "]";
	}	
}