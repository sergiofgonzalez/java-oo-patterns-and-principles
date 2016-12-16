package org.joolzminer.examples.patterns.command;

import java.util.Arrays;

public class MacroCommand implements Command {

	private Command[] commands;
	
	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}
	
	@Override
	public void execute() {
		Arrays.stream(commands)
			.forEach(Command::execute);
	}

	@Override
	public void undo() {
		// Let's assume ordering is unimportant here....
		Arrays.stream(commands)
		.forEach(Command::undo);
	}

}
