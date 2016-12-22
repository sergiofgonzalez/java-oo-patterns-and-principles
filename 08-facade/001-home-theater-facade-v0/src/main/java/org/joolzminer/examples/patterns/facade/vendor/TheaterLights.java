package org.joolzminer.examples.patterns.facade.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheaterLights {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TheaterLights.class);
	
	private boolean isLightOn = false;
	
	public void on() {
		LOGGER.debug("TheaterLights.on");
		isLightOn = true;
	}
	
	public void off() {
		LOGGER.debug("TheaterLights.off");
		isLightOn = false;
	}
	
	public void dim() {
		LOGGER.debug("TheaterLights.dim");
	}

	@Override
	public String toString() {
		return "TheaterLights [isLightOn=" + isLightOn + "]";
	}
}
