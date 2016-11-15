package org.joolzminer.examples.patterns.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MallardDuck extends Duck {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(MallardDuck.class);
	
	@Override
	public String display() {
		return "MallardDuck.display";
	}

}
