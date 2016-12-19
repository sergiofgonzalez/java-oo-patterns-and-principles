package org.joolzminer.examples.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.joolzminer.examples.patterns.RemoteControl;
import org.joolzminer.examples.patterns.command.CeilingFanCommandHolder;
import org.joolzminer.examples.patterns.command.Command;
import org.joolzminer.examples.patterns.command.GarageDoorCommandHolder;
import org.joolzminer.examples.patterns.command.LightCommandHolder;
import org.joolzminer.examples.patterns.command.MacroCommand;
import org.joolzminer.examples.patterns.command.StereoCommandHolder;
import org.joolzminer.examples.patterns.vendor.CeilingFan;
import org.joolzminer.examples.patterns.vendor.CeilingFan.Speed;
import org.joolzminer.examples.patterns.vendor.GarageDoor;
import org.joolzminer.examples.patterns.vendor.Light;
import org.joolzminer.examples.patterns.vendor.Stereo;
import org.junit.Test;

public class RemoteControlTest {

	@Test
	public void testRemoteControlLightsOnOff() {
		RemoteControl remoteControl = new RemoteControl();
		Light light = new Light(); 
		LightCommandHolder lightCommandHolder = new LightCommandHolder(light);
		remoteControl.setCommand(0, lightCommandHolder.getLightOnCommand(), lightCommandHolder.getLightOffCommand());

		remoteControl.onButtonWasPushed(0);
		assertThat(light.isOn(), is(true));
		
		remoteControl.offButtonWasPushed(0);
		assertThat(light.isOn(), is(false));
	}	
	
	
	@Test
	public void testRemoteControlMacro() {
		RemoteControl remoteControl = new RemoteControl();
		Light hallLight = new Light();	
		LightCommandHolder hallLightCommandHolder = new LightCommandHolder(hallLight);
		GarageDoor garageDoor = new GarageDoor();		
		GarageDoorCommandHolder garageDoorCommandHolder = new GarageDoorCommandHolder(garageDoor);
		Stereo stereo = new Stereo();	
		StereoCommandHolder stereoCommandHolder = new StereoCommandHolder(stereo);
		CeilingFan ceilingFan = new CeilingFan();
		CeilingFanCommandHolder ceilingFanCommandHolder = new CeilingFanCommandHolder(ceilingFan);
		
		Command[] commands = { 
				hallLightCommandHolder.getLightOnCommand(), 
				garageDoorCommandHolder.getGarageDoorUpCommand(), 
				stereoCommandHolder.getStereoOnWithCdSetCommand(),
				ceilingFanCommandHolder.getCeilingFanHighCommand() };
		
		MacroCommand macroCommand = new MacroCommand(commands);
		
		
		remoteControl.setCommand(6, macroCommand, () -> {});
		
		remoteControl.onButtonWasPushed(6);
		
		assertThat(hallLight.isOn(), is(true));
		assertThat(garageDoor.isDoorUp(), is(true));
		assertThat(ceilingFan.getSpeed(), is(Speed.HIGH));
		
	}
}
