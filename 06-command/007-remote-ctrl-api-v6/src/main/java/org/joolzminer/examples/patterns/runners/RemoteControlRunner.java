package org.joolzminer.examples.patterns.runners;

import org.joolzminer.examples.patterns.RemoteControl;
import org.joolzminer.examples.patterns.command.LightCommandHolder;
import org.joolzminer.examples.patterns.command.StereoCommandHolder;
import org.joolzminer.examples.patterns.vendor.Light;
import org.joolzminer.examples.patterns.vendor.Stereo;

public class RemoteControlRunner {
		
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
		
		// Checking that out of the box, the remote is not configured
		System.out.println(remoteControl);
		
		// Setting up lights on slot 0
		Light hallLight = new Light();
		LightCommandHolder hallLightCommandHolder = new LightCommandHolder(hallLight);
		remoteControl.setCommand(0, hallLightCommandHolder::getLightOnCommand, 
									hallLightCommandHolder::getLightOffCommand);

		System.out.println(remoteControl);
	
		// Pushing slot 0, ON button
		remoteControl.onButtonWasPushed(0);
		
		// Pushing slot 0, OFF button
		remoteControl.offButtonWasPushed(0);
		
		printSeparator();
		
		// Configuring slot 1 for Stereo CD
		Stereo livingRoomStereo = new Stereo();
		StereoCommandHolder livingRoomStereoCommandHolder = new StereoCommandHolder(livingRoomStereo);
		
		remoteControl.setCommand(1, livingRoomStereoCommandHolder::getStereoOnWithCdSetCommand,
									livingRoomStereoCommandHolder::getStereoOffCommand);
		
		// Now turn on the stereo!!
		remoteControl.onButtonWasPushed(1);
		
		printSeparator();
		
		System.out.println(remoteControl);
		
		// Let's see what happens when we push a button that has not been programmed yet
		remoteControl.onButtonWasPushed(5);
	}
	
	private static void printSeparator() {
		System.out.println("=============================================================================");
	}
}
