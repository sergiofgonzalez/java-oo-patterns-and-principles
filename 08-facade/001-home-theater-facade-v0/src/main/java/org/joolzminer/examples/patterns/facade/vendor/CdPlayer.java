package org.joolzminer.examples.patterns.facade.vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CdPlayer {
	private static final Logger LOGGER = LoggerFactory.getLogger(DvdPlayer.class);
	
	private Amplifier amplifier;
	
	private boolean isOn;
	
	private enum PlayingMode { STOP, PAUSE, PLAYING };
	
	private PlayingMode playingMode;
	
	private boolean isSurroundOn;
	
	private boolean isTwoChannelAudioOn;
	
	private boolean isDvdTrayOpen;
	
	public CdPlayer(Amplifier amplifier) {
		this.amplifier = amplifier;
		isOn = false;
		isSurroundOn = false;
		playingMode = PlayingMode.STOP;
		isTwoChannelAudioOn = false;
		isDvdTrayOpen = false;
	}
	
	public boolean isOn() {
		return isOn;
	}

	public void on() {
		LOGGER.debug("CdPlayer.on");
		isOn = true;
		isDvdTrayOpen = false;
	}

	public void off() {
		LOGGER.debug("CdPlayer.off");
		isOn = false;
		isDvdTrayOpen = false;
	}
	
	public void eject() {
		LOGGER.debug("CdPlayer.eject");
		if (isOn) {
			isDvdTrayOpen = true;
			playingMode = PlayingMode.STOP;
		}
	}
	
	public void pause() {
		LOGGER.debug("CdPlayer.pause");
		if (isOn && !isDvdTrayOpen ) {
			playingMode = PlayingMode.PAUSE;
		}
	}
	
	public void play() {
		LOGGER.debug("CdPlayer.play");
		if (isOn) {
			playingMode = PlayingMode.PLAYING;
			isDvdTrayOpen = false;
		}
	}
	
	public void stop() {
		LOGGER.debug("CdPlayer.stop");
		if (isOn) {
			playingMode = PlayingMode.STOP;
		}
	}
	
	public void turnOnSurroundAudio() {		
		LOGGER.debug("CdPlayer.turnOnSurroundAudio");
		if (isOn) {
			isSurroundOn = true;
		}
	}
	
	public void turnOnTwoChannelAudio() {
		LOGGER.debug("CdPlayer.turnOnChannelAudio");
		if (isOn) {
			isTwoChannelAudioOn = true;
		}
	}
	
	@Override
	public String toString() {
		return "CdPlayer [amplifier=" + amplifier + ", isOn=" + isOn
				+ ", playingMode=" + playingMode + ", isSurroundOn="
				+ isSurroundOn + ", isTwoChannelAudioOn=" + isTwoChannelAudioOn
				+ ", isDvdTrayOpen=" + isDvdTrayOpen + "]";
	}
}
