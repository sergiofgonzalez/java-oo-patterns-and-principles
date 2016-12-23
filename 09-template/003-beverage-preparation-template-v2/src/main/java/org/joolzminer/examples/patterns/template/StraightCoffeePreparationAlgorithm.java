package org.joolzminer.examples.patterns.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StraightCoffeePreparationAlgorithm extends BeveragePreparationAlgorithmTemplate {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StraightCoffeePreparationAlgorithm.class);

	@Override
	protected void brewBeverage() {
		LOGGER.debug("CoffeePreparationAlgorithm.brewBeverage: brewing coffee in boiling water");
	}
}
