package org.joolzminer.examples.patterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MallardDuck implements Duck {

	private static final Logger LOGGER = LoggerFactory.getLogger(MallardDuck.class);
	
	@Override
	public void quack() {
		LOGGER.debug("MallardDuck.quack");
	}

	@Override
	public void fly() {
		LOGGER.debug("MallardDuck.fly");
	}
}
