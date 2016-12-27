package org.joolzminer.examples.patterns.domain.runner;

import org.joolzminer.examples.patterns.services.MenuServices;


public class MenuRunner {

	public static void main(String[] args) {
		MenuServices menuServices = new MenuServices();
		menuServices.printMenu();
		printSeparator();
		
		menuServices.printLunchMenu();
		printSeparator();
		
		menuServices.printBreakfastMenu();
		printSeparator();
		
		menuServices.printVegetarianMenu();
		printSeparator();
	}
	
	private static void printSeparator() {
		System.out.println();
	}
}
