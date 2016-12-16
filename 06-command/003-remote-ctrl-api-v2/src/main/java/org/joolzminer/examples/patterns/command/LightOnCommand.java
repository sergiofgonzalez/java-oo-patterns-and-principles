package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.Light;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LightOnCommand implements Command {

	private static final Logger LOGGER = LoggerFactory.getLogger(LightOnCommand.class);
	
	private Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		LOGGER.debug("Executing command");
		light.on();
	}

	@Override
	public void undo() {
		LOGGER.debug("Undoing command");
		light.off();
	}
}
