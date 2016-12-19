package org.joolzminer.examples.patterns.command;

import org.joolzminer.examples.patterns.vendor.Light;

public class LightCommandHolder {
	
	private Light light; 
	
	private Command lightOnCommand = () -> { 
		System.out.println("inside"); 
		light.on(); };
	
	private Command lightOffCommand = () -> light.off();
	
	public LightCommandHolder(Light light) {
		this.light = light;
	}	
		
	public Command getLightOnCommand() {
		return () -> { 
			System.out.println("inside"); 
			light.on(); };
	}
	
	public Command getLightOffCommand() {
		return lightOffCommand;
	}
}
