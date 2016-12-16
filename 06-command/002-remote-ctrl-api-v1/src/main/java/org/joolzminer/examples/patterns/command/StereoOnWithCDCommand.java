package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.Stereo;

public class StereoOnWithCDCommand implements Command {

	private Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	@Override
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume(3);
	}
}
