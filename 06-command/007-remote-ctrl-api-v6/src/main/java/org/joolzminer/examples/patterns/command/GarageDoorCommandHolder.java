package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.GarageDoor;

public class GarageDoorCommandHolder {

	private GarageDoor garageDoor;
	
	private Command garageDoorUpCommand = () -> garageDoor.up();
	
	public GarageDoorCommandHolder(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public Command getGarageDoorUpCommand() {
		return garageDoorUpCommand;
	}	
}
