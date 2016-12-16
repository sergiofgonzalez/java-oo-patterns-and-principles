package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.Light;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LightOffCommand implements Command {

	private static final Logger LOGGER = LoggerFactory.getLogger(LightOffCommand.class);
	
	private Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		LOGGER.debug("Executing command");
		light.off();
	}
}
