package org.joolzminer.examples.patterns.runner;

import org.joolzminer.examples.patterns.algorithms.BeveragePreparationAlgorithm;
import org.joolzminer.examples.patterns.algorithms.CoffeePreparationAlgorithm;
import org.joolzminer.examples.patterns.algorithms.TeaPreparationAlgorithm;

public class BeveragePreparationRunner {

	public static void main(String[] args) {
		BeveragePreparationAlgorithm coffePreparationAlgorithm = new CoffeePreparationAlgorithm();
		coffePreparationAlgorithm.prepareBeverage();
		printSeparator();
		
		BeveragePreparationAlgorithm teaPreparationAlgorithm = new TeaPreparationAlgorithm();
		teaPreparationAlgorithm.prepareBeverage();
		printSeparator();
	}
	
	private static void printSeparator() {
		System.out.println();
	}
}
