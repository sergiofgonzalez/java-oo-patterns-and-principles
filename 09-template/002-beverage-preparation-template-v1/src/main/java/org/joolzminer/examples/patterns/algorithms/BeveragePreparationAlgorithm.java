package org.joolzminer.examples.patterns.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BeveragePreparationAlgorithm {

	private static final Logger LOGGER = LoggerFactory.getLogger(BeveragePreparationAlgorithm.class);
	
	public final void prepareBeverage() {
		boilWater();
		brewBeverage();
		pourBeverageInCup();
		addCondiments();
	}
	
	protected void boilWater() {
		LOGGER.debug("BeveragePreparationAlgorithm.boilWater");
	}
	
	protected void pourBeverageInCup() {
		LOGGER.debug("BeveragePreparationAlgorithm.pourBeverageInCup");
	}
	
	protected abstract void brewBeverage();
	
	protected abstract void addCondiments();
}
