package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.CeilingFan;
import org.joolzminer.examples.patterns.vendor.CeilingFan.Speed;

public class CeilingFanLowCommand implements Command {

	private CeilingFan ceilingFan;

	private Speed prevSpeed;
	
	public CeilingFanLowCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	
	
	@Override
	public void execute() {
		prevSpeed = ceilingFan.getSpeed();
		ceilingFan.low();
	}

	@Override
	public void undo() {
		switch (prevSpeed) {
			case OFF:
				ceilingFan.off();
				break;
				
			case LOW:
				ceilingFan.low();
				break;
				
			case MEDIUM:
				ceilingFan.medium();
				break;
			
			case HIGH:
				ceilingFan.high();
				break;
			
			default:
				throw new IllegalStateException();
		}
	}
}
