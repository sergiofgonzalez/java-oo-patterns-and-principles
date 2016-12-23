package org.joolzminer.examples.patterns.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoffeePreparationAlgorithm extends BeveragePreparationAlgorithmTemplate {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoffeePreparationAlgorithm.class);

	@Override
	protected void brewBeverage() {
		LOGGER.debug("CoffeePreparationAlgorithm.brewBeverage: brewing coffee in boiling water");
	}

	@Override
	protected void addCondiments() {
		LOGGER.debug("CoffeePreparationAlgorithm.addCondiments: adding sugar and milk");		
	}	
	
}
