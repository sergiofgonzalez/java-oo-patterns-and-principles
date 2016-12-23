package org.joolzminer.examples.patterns.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeaPreparationAlgorithm extends BeveragePreparationAlgorithm {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TeaPreparationAlgorithm.class);
	
	@Override
	protected void brewBeverage() {
		LOGGER.debug("TeaPreparationAlgorithm.brewBeverage: putting tea bag in boiling water");
	}

	@Override
	protected void addCondiments() {
		LOGGER.debug("TeaPreparationAlgorithm.addCondiments: adding lemon");		
	}	
}
