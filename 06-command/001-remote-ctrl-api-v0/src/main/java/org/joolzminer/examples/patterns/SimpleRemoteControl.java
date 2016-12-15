package org.joolzminer.examples.patterns;

import org.joolzminer.examples.patterns.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleRemoteControl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRemoteControl.class);
	
	private Command slot;

	public void setCommand(Command command) {
		this.slot = command;
	}
	
	public void buttonWasPressed() {
		LOGGER.debug("A button in the controller has been pressed");
		slot.execute();
	}
}
