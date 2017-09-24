package org.joolzminer.examples.runners;

import org.joolzminer.examples.domain.Person;
import org.joolzminer.examples.patterns.builder.AddressBuilder;
import org.joolzminer.examples.patterns.builder.PersonBuilder;

public class ApplicationRunner {
	
	public static void main(String[] args) {

		Person p = new PersonBuilder()
							.withSalutation("Dr.")
							.withFirstName("Sheldon")
							.withMiddleName("C.")
							.withLastName("Cooper")
							.withAddress(new AddressBuilder()
												.withCity("Madrid")
												.withCountry("Spain")
												.withStreet("Orense")
												.withZipCode("28020")
												.build())
							.build();
		
		System.out.println(p);
	}
}
