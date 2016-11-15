package org.joolzminer.examples.patterns.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecoyDuck extends Duck {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(DecoyDuck.class);
		
	@Override
	public String display() {
		return "DecoyDuck.display";
	}	
}
