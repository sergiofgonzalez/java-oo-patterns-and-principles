package org.joolzminer.examples.patterns.facade.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PopcornPopper {
	private static final Logger LOGGER = LoggerFactory.getLogger(PopcornPopper.class);
	
	private boolean isOn = false;
	
	public void on() {
		LOGGER.debug("PopcornPopper.on");
		isOn = true;
	}
	
	public void off() {
		LOGGER.debug("PopcornPopper.off");
		isOn = false;
	}
	
	public void pop() {
		LOGGER.debug("PopcornPopper.pop");
		if (isOn) {
			LOGGER.debug("Popping porcorn...");
		}
	}

	@Override
	public String toString() {
		return "PopcornPopper [isOn=" + isOn + "]";
	}
	
	
}
