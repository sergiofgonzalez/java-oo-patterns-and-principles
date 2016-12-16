package org.joolzminer.examples.patterns.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GarageDoor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GarageDoor.class);
	
	private boolean isDoorUp;
	private boolean isLightOn;
	
	public GarageDoor() {
		this.isDoorUp = false;
		this.isLightOn = false;
	}
	
	public void up() {
		isDoorUp = true;
		LOGGER.debug("Garage door is going up: {}", this);
	}

	public void down() {
		isDoorUp = false;
		LOGGER.debug("Garage door is going down: {}", this);
	}
	
	public void stop() {
		LOGGER.debug("Garage door is stopped: {}", this);
	}
	
	public void lightOn() {
		isDoorUp = true;
		LOGGER.debug("Garage door light turned on: {}", this);
	}

	public void lightOff() {
		isDoorUp = false;
		LOGGER.debug("Garage door light turned off: {}", this);
	}
		
	public boolean isDoorUp() {
		return isDoorUp;
	}

	public boolean isLightOn() {
		return isLightOn;
	}

	@Override
	public String toString() {
		return "GarageDoor [isDoorUp=" + isDoorUp + ", isLightOn=" + isLightOn + "]";
	}
}
