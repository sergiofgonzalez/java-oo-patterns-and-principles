package org.joolzminer.examples.patterns;

import org.joolzminer.examples.patterns.command.Command;
import org.joolzminer.examples.patterns.command.NoConfiguredCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteControl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RemoteControl.class);
	
	private static final int NUM_BUTTON_ROWS = 7;
	
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;
	
	public RemoteControl() {
		onCommands = new Command[NUM_BUTTON_ROWS];
		offCommands = new Command[NUM_BUTTON_ROWS];
		
		for (int i = 0; i < onCommands.length; i++) {
			onCommands[i] = NoConfiguredCommand.INSTANCE;
			offCommands[i] = NoConfiguredCommand.INSTANCE;
		}
		
		undoCommand = NoConfiguredCommand.INSTANCE;
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		if (slot < 0 || slot > (NUM_BUTTON_ROWS - 1)) {
			LOGGER.error("slot index is out of range: {}", slot);
			throw new IllegalArgumentException("slot index is out of range: " + slot);
		}
		
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
	
	public void onButtonWasPushed(int slot) {
		undoCommand = onCommands[slot];
		onCommands[slot].execute();
		
	}
	
	public void offButtonWasPushed(int slot) {
		undoCommand = offCommands[slot];
		offCommands[slot].execute();
	}
	
	public void undoButtonWasPushed() {
		undoCommand.undo();
		undoCommand = NoConfiguredCommand.INSTANCE;  		
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("============= Remote Controller (current status) =============\n");
		for (int i = 0; i < NUM_BUTTON_ROWS; i++) {
			sb.append(i);
			sb.append(": ");
			sb.append("ON -> ");
			sb.append(onCommands[i].getClass().getSimpleName());
			sb.append(", OFF -> ");
			sb.append(offCommands[i].getClass().getSimpleName());			
			sb.append("\n");
		}
		sb.append("UNDO -> ");
		sb.append(undoCommand.getClass().getSimpleName());		
		sb.append("\n");
		sb.append("==============================================================\n");
		
		return sb.toString();
	}	
}
