package org.joolzminer.examples.patterns.command;

import java.util.function.Function;

import org.joolzminer.examples.patterns.vendor.CeilingFan;

public class CeilingFanCommandHolder {

	public static final Function<CeilingFan, Command> ceilingFanHighFn = ceilingFan -> () -> ceilingFan.high();
	
	private CeilingFanCommandHolder() {
		// prevent instantiation
	}
}
