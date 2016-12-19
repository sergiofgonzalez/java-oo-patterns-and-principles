package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.Light;

public class LightCommandHolder {
	
	private Light light; 
	
	private Command lightOnCommand = () -> light.on();
	
	private Command lightOffCommand = () -> light.off();
	
	public LightCommandHolder(Light light) {
		this.light = light;
	}	
	
	
	public Command getLightOnCommand() {
		return lightOnCommand;
	}
	
	public Command getLightOffCommand() {
		return lightOffCommand;
	}
}
