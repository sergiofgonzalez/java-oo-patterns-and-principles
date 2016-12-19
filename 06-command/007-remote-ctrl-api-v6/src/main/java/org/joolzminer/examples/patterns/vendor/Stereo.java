package org.joolzminer.examples.patterns.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stereo {

	private static final Logger LOGGER = LoggerFactory.getLogger(Stereo.class);
	
	public void on() {
		LOGGER.debug("Stereo is on");
	}
	
	public void off() {
		LOGGER.debug("Stereo is off");
	}
	
	public void setCd() {
		LOGGER.debug("Stereo is on CD mode");
	}	
	
	public void setDvd() {
		LOGGER.debug("Stereo is on DVD mode");
	}	
	
	public void setRadio() {
		LOGGER.debug("Stereo is on Radio mode");
	}	
	
	public void setVolume(int volume) {
		LOGGER.debug("Stereo volume is set to {}", volume);
	}		
}
