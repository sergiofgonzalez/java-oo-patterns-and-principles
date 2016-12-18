package org.joolzminer.examples.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.joolzminer.examples.patterns.RemoteControl;
import org.joolzminer.examples.patterns.command.Command;
import org.joolzminer.examples.patterns.command.MacroCommand;
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
		remoteControl.setCommand(0, light::on, light::off);

		remoteControl.onButtonWasPushed(0);
		assertThat(light.isOn(), is(true));
		
		remoteControl.offButtonWasPushed(0);
		assertThat(light.isOn(), is(false));
	}	
	
	
	@Test
	public void testRemoteControlMacro() {
		RemoteControl remoteControl = new RemoteControl();
		Light hallLight = new Light();
		Command lightOnCommand = hallLight::on;
		
		GarageDoor garageDoor = new GarageDoor();
		Command openGarageDoorCommand = garageDoor::up;
		
		Stereo stereo = new Stereo();
		Command stereoOnWithCDCommand = () -> {
			stereo.on();
			stereo.setCd();
			stereo.setVolume(11);
		};
		
		CeilingFan ceilingFan = new CeilingFan();
		Command ceilingFanHighCommand = ceilingFan::high;
		
		Command[] commands = { lightOnCommand, openGarageDoorCommand, stereoOnWithCDCommand, ceilingFanHighCommand };
		MacroCommand macroCommand = new MacroCommand(commands);
		
		
		remoteControl.setCommand(6, macroCommand, () -> {});
		
		remoteControl.onButtonWasPushed(6);
		
		assertThat(hallLight.isOn(), is(true));
		assertThat(garageDoor.isDoorUp(), is(true));
		assertThat(ceilingFan.getSpeed(), is(Speed.HIGH));
		
	}
}
