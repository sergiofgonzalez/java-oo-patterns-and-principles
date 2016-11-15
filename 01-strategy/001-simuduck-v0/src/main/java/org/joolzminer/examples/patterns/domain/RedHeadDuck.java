package org.joolzminer.examples.patterns.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedHeadDuck extends Duck {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(RedHeadDuck.class);
	
	@Override
	public String display() {
		return "RedHeadDuck.display";
	}

}
