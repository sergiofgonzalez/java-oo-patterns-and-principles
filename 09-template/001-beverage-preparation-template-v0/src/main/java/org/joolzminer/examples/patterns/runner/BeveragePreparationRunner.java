package org.joolzminer.examples.patterns.runner;

import org.joolzminer.examples.patterns.algorithms.CoffeePreparationAlgorithm;
import org.joolzminer.examples.patterns.algorithms.TeaPreparationAlgorithm;

public class BeveragePreparationRunner {

	public static void main(String[] args) {
		CoffeePreparationAlgorithm coffePreparationAlgorithm = new CoffeePreparationAlgorithm();
		coffePreparationAlgorithm.prepareCoffeeBeverage();
		printSeparator();
		
		TeaPreparationAlgorithm teaPreparationAlgorithm = new TeaPreparationAlgorithm();
		teaPreparationAlgorithm.prepareTeaBeverage();
		printSeparator();
	}
	
	private static void printSeparator() {
		System.out.println();
	}
}
