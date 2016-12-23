package org.joolzminer.examples.patterns.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BeveragePreparationAlgorithmTemplate {

	private static final Logger LOGGER = LoggerFactory.getLogger(BeveragePreparationAlgorithmTemplate.class);
	
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
	
	protected void addCondiments() { };

}
