package org.joolzminer.examples.patterns.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoConfiguredCommand implements Command {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NoConfiguredCommand.class);

	public static final NoConfiguredCommand INSTANCE = new NoConfiguredCommand();
		
	@Override
	public void execute() {
		LOGGER.debug("Nothing configured yet!");
	}	
}
