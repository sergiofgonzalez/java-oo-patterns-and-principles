package org.joolzminer.examples.patterns.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Duck {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(Duck.class);
	
	public String swim() {
		return "Duck.swim";
	}
	
	public abstract String display();
}
