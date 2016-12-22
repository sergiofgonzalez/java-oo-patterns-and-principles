package org.joolzminer.examples.patterns.facade.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Projector {
	private static final Logger LOGGER = LoggerFactory.getLogger(Projector.class);
	
	private DvdPlayer dvdPlayer;
	
	private boolean isOn;
	private boolean isOnTvMode;
	private boolean isOnWideScreenMode;
	
	public Projector(DvdPlayer dvdPlayer) {
		this.dvdPlayer = dvdPlayer;
		isOn = false;
		isOnTvMode = true;
		isOnWideScreenMode = false;
	}
		
	public void on() {
		LOGGER.debug("Projector.on");
		isOn = true;
	}
	
	public void off() {
		LOGGER.debug("Projector.off");
		isOn = false;
	}
	
	public void tvMode() {
		LOGGER.debug("Projector.tvMode");
		isOnTvMode = true;
	}
	
	public void dvdMode() {
		LOGGER.debug("Projector.dvdMode");
		isOnTvMode = false;
	}
	
	public void wideScreenModeSwitch() {
		LOGGER.debug("Projector.wideScreenModeSwitch");
		isOnTvMode = !isOnTvMode;
	}

	@Override
	public String toString() {
		return "Projector [dvdPlayer=" + dvdPlayer + ", isOn=" + isOn
				+ ", isOnTvMode=" + isOnTvMode + ", isOnWideScreenMode="
				+ isOnWideScreenMode + "]";
	}
}
