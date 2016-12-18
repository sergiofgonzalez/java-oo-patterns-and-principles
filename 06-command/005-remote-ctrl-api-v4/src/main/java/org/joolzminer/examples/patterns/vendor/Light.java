package org.joolzminer.examples.patterns.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Light {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Light.class);
	
	private boolean isOn;

	public Light() {
		isOn = false;
	}
	
	public void on() {
		isOn = true;
		LOGGER.debug("Turning on the lights: {}", this);
	}
	
	public void off() {
		isOn = false;
		LOGGER.debug("Turning off the lights: {}", this);
	}
	
	public boolean isOn() {
		return isOn;
	}

	@Override
	public String toString() {
		return "Light [isOn=" + isOn + "]";
	}
	
	
}
