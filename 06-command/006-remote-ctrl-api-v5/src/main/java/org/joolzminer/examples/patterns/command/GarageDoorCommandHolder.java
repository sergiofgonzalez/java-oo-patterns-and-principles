package org.joolzminer.examples.patterns.command;

import java.util.function.Function;

import org.joolzminer.examples.patterns.vendor.GarageDoor;

public class GarageDoorCommandHolder {

	public static final Function<GarageDoor, Command> garageDoorUpFn = garageDoor -> () -> garageDoor.up();
	
	private GarageDoorCommandHolder() {
		// prevent instantiation
	}
}
