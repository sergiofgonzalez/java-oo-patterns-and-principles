package org.joolzminer.examples.patterns.facade.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Amplifier {
	private static final Logger LOGGER = LoggerFactory.getLogger(Amplifier.class);
	
	private int volumeLevel;
	private boolean isOn;
	private boolean isDvdModeOn;
	private boolean isSurroundModeOn;
	
	private Tuner tuner;
	private DvdPlayer dvdPlayer;
	private CdPlayer cdPlayer;
	
	
	public Amplifier() {
		this.isDvdModeOn = true;
		this.isSurroundModeOn = false;
		isOn = false;
	}
		
	
	public void setDvdPlayer(DvdPlayer dvdPlayer) {
		this.dvdPlayer = dvdPlayer;
	}

	public void setCdPlayer(CdPlayer cdPlayer) {
		this.cdPlayer = cdPlayer;
	}

	public void on() {
		LOGGER.debug("Amplifier.on");
		isOn = true;
	}
	
	public void off() {
		LOGGER.debug("Amplifier.off");
		isOn = false;
	}
		
	public boolean isOn() {
		return isOn;
	}
	
	public int getVolumeLevel() {
		return volumeLevel;
	}

	public void setVolume(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	public void setDvdModeOn() {
		this.isDvdModeOn = true;
	}
	
	public void setCdModeOn() {
		this.isDvdModeOn = false;
	}
	
	public void surroundModeSwitch() {
		this.isSurroundModeOn = !isSurroundModeOn;
	}
		
	public boolean isSurroundModeOn() {
		return isSurroundModeOn;
	}

	@Override
	public String toString() {
		return "Amplifier [volumeLevel=" + volumeLevel + ", isOn=" + isOn
				+ ", isDvdModeOn=" + isDvdModeOn + ", isSurroundModeOn="
				+ isSurroundModeOn + ", tuner=" + tuner + ", dvdPlayer="
				+ dvdPlayer + ", cdPlayer=" + cdPlayer + "]";
	}
}
