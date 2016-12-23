package org.joolzminer.examples.patterns.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeaPreparationAlgorithm {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TeaPreparationAlgorithm.class);
	
	public void prepareTeaBeverage() {
		LOGGER.debug("Preparing Tea");
		boilWater();
		steepTeaBagInWater();
		pourTeaInCup();
		addLemon();
	}

	private void addLemon() {
		LOGGER.debug("Adding Lemon");
	}

	private void pourTeaInCup() {
		LOGGER.debug("Pouring Tea in a cup");
		
	}

	private void steepTeaBagInWater() {
		LOGGER.debug("Putting Tea Bag in boiling water");
		
	}

	private void boilWater() {
		LOGGER.debug("Boiling water");
	}
	
	
}
