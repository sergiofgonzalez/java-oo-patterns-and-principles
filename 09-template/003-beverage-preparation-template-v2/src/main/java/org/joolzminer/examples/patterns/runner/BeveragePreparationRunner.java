package org.joolzminer.examples.patterns.runner;

import org.joolzminer.examples.patterns.template.BeveragePreparationAlgorithmTemplate;
import org.joolzminer.examples.patterns.template.CoffeePreparationAlgorithm;
import org.joolzminer.examples.patterns.template.StraightCoffeePreparationAlgorithm;
import org.joolzminer.examples.patterns.template.TeaPreparationAlgorithm;

public class BeveragePreparationRunner {

	public static void main(String[] args) {
		BeveragePreparationAlgorithmTemplate coffePreparationAlgorithm = new CoffeePreparationAlgorithm();
		coffePreparationAlgorithm.prepareBeverage();
		printSeparator();
		
		BeveragePreparationAlgorithmTemplate teaPreparationAlgorithm = new TeaPreparationAlgorithm();
		teaPreparationAlgorithm.prepareBeverage();
		printSeparator();
		
		BeveragePreparationAlgorithmTemplate straightCoffePreparationAlgorithm = new StraightCoffeePreparationAlgorithm();
		straightCoffePreparationAlgorithm.prepareBeverage();
		printSeparator();
	}
	
	private static void printSeparator() {
		System.out.println();
	}
}
