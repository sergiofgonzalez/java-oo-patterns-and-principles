package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.Quackable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubberDuck extends Duck implements Quackable {

	private static final Logger LOGGER = LoggerFactory.getLogger(RubberDuck.class);
	
	@Override
	public String display() {
		return "RubberDuck.display";
	}

	@Override
	public String quack() {
		LOGGER.debug("Squeeeak!!");
		return "RubberDuck.quack";
	}
	
	
}
