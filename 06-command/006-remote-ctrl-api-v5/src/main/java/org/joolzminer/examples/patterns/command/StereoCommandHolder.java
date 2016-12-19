package org.joolzminer.examples.patterns.command;

import java.util.function.Function;

import org.joolzminer.examples.patterns.vendor.Stereo;

public class StereoCommandHolder {

	public static Function<Stereo,Command> stereoOnWithCdSetFn = stereo -> () -> {
		stereo.on();
		stereo.setCd();
		stereo.setVolume(5);
	};
	
	public static Function<Stereo,Command> stereoOffWithCdSetFn = stereo -> () -> stereo.off();
	
	private StereoCommandHolder() {
		// prevent instantiation
	}
}
