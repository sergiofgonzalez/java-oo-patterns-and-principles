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
		remoteControl.setCommand(0, LightCommandHolder.lightOnFn.apply(light), LightCommandHolder.lightOffFn.apply(light));

		remoteControl.onButtonWasPushed(0);
		assertThat(light.isOn(), is(true));
		
		remoteControl.offButtonWasPushed(0);
		assertThat(light.isOn(), is(false));
	}	
	
	
	@Test
	public void testRemoteControlMacro() {
		RemoteControl remoteControl = new RemoteControl();
		Light hallLight = new Light();		
		GarageDoor garageDoor = new GarageDoor();		
		Stereo stereo = new Stereo();		
		CeilingFan ceilingFan = new CeilingFan();
		
		Command[] commands = { 
				LightCommandHolder.lightOnFn.apply(hallLight), 
				GarageDoorCommandHolder.garageDoorUpFn.apply(garageDoor), 
				StereoCommandHolder.stereoOnWithCdSetFn.apply(stereo),
				CeilingFanCommandHolder.ceilingFanHighFn.apply(ceilingFan)};
		
		MacroCommand macroCommand = new MacroCommand(commands);
		
		
		remoteControl.setCommand(6, macroCommand, () -> {});
		
		remoteControl.onButtonWasPushed(6);
		
		assertThat(hallLight.isOn(), is(true));
		assertThat(garageDoor.isDoorUp(), is(true));
		assertThat(ceilingFan.getSpeed(), is(Speed.HIGH));
		
	}
}
