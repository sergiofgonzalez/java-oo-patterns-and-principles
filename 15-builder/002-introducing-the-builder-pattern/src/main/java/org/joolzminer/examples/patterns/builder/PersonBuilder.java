package org.joolzminer.examples.patterns.builder;

import org.joolzminer.examples.domain.Address;
import org.joolzminer.examples.domain.Person;

public class PersonBuilder {
	private String salutation;
	private String firstName;
	private String middleName;
	private String lastName;
	private Address address;

	
	public PersonBuilder withSalutation(String salutation) {
		this.salutation = salutation;
		return this;
	}
	
	public PersonBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public PersonBuilder withMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}	
	
	public PersonBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}	
	
	public PersonBuilder withAddress(Address address) {
		this.address = address;
		return this;
	}
	
	public Person build() {
		return new Person(salutation, firstName, middleName, lastName, address);
	}
	
}
