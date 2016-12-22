package org.joolzminer.examples.patterns.facade.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tuner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Tuner.class);
	
	private Amplifier amplifier;
	
	private boolean isOn;
	
	public Tuner(Amplifier amplifier) {
		this.amplifier = amplifier;
		isOn = false;
	}
	
	public boolean isOn() {
		return isOn;
	}

	public void on() {
		LOGGER.debug("Tuner.on");
		isOn = true;
	}

	@Override
	public String toString() {
		return "Tuner [amplifier=" + amplifier + ", isOn=" + isOn + "]";
	}
}
