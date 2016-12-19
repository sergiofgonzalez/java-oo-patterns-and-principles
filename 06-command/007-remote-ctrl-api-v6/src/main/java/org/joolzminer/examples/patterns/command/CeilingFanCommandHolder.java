package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.CeilingFan;

public class CeilingFanCommandHolder {

	private CeilingFan ceilingFan;
	
	private Command ceilingFanHighCommand = () -> ceilingFan.high(); 
	
	public CeilingFanCommandHolder(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	public Command getCeilingFanHighCommand() {
		return ceilingFanHighCommand;
	}	

}
