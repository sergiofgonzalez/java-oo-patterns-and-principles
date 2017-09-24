package org.joolzminer.examples.patterns.builder;

import org.joolzminer.examples.domain.Address;

public class AddressBuilder {
	private String street;
	private String city;
	private String country;
	private String zipCode;
	
	public AddressBuilder withStreet(String street) {
		this.street = street;
		return this;
	}
	
	public AddressBuilder withCity(String city) {
		this.city = city;
		return this;
	}
	
	public AddressBuilder withCountry(String country) {
		this.country = country;
		return this;
	}	
	
	public AddressBuilder withZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}	
	
	public Address build() {
		return new Address(street, city, country, zipCode);
	}
	
}
