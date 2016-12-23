package org.joolzminer.examples.patterns.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoffeePreparationAlgorithm {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoffeePreparationAlgorithm.class);
	
	public void prepareCoffeeBeverage() {
		LOGGER.debug("Preparing Coffee");
		boilWater();
		brewCoffeeInWater();
		pourCoffeInCup();
		addSugarAndMilk();
	}

	private void addSugarAndMilk() {
		LOGGER.debug("Adding sugar and milk");
	}

	private void pourCoffeInCup() {
		LOGGER.debug("Pouring coffee in cup");	
	}

	private void brewCoffeeInWater() {
		LOGGER.debug("Brewing coffee in water");	
	}

	private void boilWater() {
		LOGGER.debug("Boiling water");
	}
	
	
}
