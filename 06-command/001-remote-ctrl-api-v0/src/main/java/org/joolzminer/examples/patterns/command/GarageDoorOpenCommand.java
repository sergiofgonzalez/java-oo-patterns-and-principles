package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.GarageDoor;

public class GarageDoorOpenCommand implements Command {

	private GarageDoor garageDoor;
		
	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}
	
	@Override
	public void execute() {
		garageDoor.up();
	}
}
