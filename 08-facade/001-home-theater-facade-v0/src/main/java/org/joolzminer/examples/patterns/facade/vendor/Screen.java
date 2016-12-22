package org.joolzminer.examples.patterns.facade.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Screen {
	private static final Logger LOGGER = LoggerFactory.getLogger(Screen.class);
	
	private boolean isUp = false;
	
	public void up() {
		LOGGER.debug("Screen.up");
		isUp = true;
	}
	
	public void down() {
		LOGGER.debug("Screen.down");
		isUp= false;
	}

	@Override
	public String toString() {
		return "Screen [isUp=" + isUp + "]";
	}
}
