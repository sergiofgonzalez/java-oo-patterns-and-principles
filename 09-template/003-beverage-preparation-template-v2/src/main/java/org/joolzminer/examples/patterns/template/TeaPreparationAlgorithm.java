package org.joolzminer.examples.patterns.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeaPreparationAlgorithm extends BeveragePreparationAlgorithmTemplate {
	
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
