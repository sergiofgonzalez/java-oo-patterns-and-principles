package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.Stereo;

public class StereoCommandHolder {

	private Stereo stereo;

	private Command stereoOnWithCdSetCommand = () -> {
														stereo.on();
														stereo.setCd();
														stereo.setVolume(5); 
														};
	
	private Command stereoOffCommand = () -> stereo.off();

	public StereoCommandHolder(Stereo stereo) {
		this.stereo = stereo;
	}

	public Command getStereoOnWithCdSetCommand() {
		return stereoOnWithCdSetCommand;
	}

	public Command getStereoOffCommand() {
		return stereoOffCommand;
	}
	
	
}
