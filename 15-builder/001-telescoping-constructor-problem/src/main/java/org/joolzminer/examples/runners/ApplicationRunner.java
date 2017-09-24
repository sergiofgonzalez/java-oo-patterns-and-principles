package org.joolzminer.examples.runners;

import java.util.Arrays;
import java.util.List;

import org.joolzminer.examples.domain.Person;

public class ApplicationRunner {
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Sergio", "Gonzalez"),
				new Person("Sergio", "Gonzalez", "F."),
				new Person("Sergio", "Gonzalez", "F.", "Mr."));
		
		people.stream().forEach(System.out::println);
	}
}
