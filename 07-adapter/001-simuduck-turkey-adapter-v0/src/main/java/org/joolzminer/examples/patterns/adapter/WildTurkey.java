package org.joolzminer.examples.patterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WildTurkey implements Turkey {

	private static final Logger LOGGER = LoggerFactory.getLogger(WildTurkey.class);
	
	@Override
	public void gobble() {
		LOGGER.debug("WildTurkey.gobble");
	}

	@Override
	public void fly() {
		LOGGER.debug("WildTurkey.fly");
	}

}
