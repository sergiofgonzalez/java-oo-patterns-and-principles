package org.joolzminer.examples.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.joolzminer.examples.patterns.RemoteControl;
import org.joolzminer.examples.patterns.command.CeilingFanHighCommand;
import org.joolzminer.examples.patterns.command.CeilingFanLowCommand;
import org.joolzminer.examples.patterns.command.Command;
import org.joolzminer.examples.patterns.command.GarageDoorOpenCommand;
import org.joolzminer.examples.patterns.command.LightOffCommand;
import org.joolzminer.examples.patterns.command.LightOnCommand;
import org.joolzminer.examples.patterns.command.MacroCommand;
import org.joolzminer.examples.patterns.command.NoConfiguredCommand;
import org.joolzminer.examples.patterns.command.StereoOnWithCDCommand;
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
		remoteControl.setCommand(0, new LightOnCommand(light), new LightOffCommand(light));

		remoteControl.onButtonWasPushed(0);
		assertThat(light.isOn(), is(true));
		
		remoteControl.offButtonWasPushed(0);
		assertThat(light.isOn(), is(false));
	}	
	
	@Test
	public void testRemoteControlLightsUndoWithOn() {
		RemoteControl remoteControl = new RemoteControl();
		Light light = new Light(); 
		remoteControl.setCommand(0, new LightOnCommand(light), new LightOffCommand(light));

		remoteControl.onButtonWasPushed(0);
		assertThat(light.isOn(), is(true));
		
		remoteControl.undoButtonWasPushed();
		assertThat(light.isOn(), is(false));
	}	
	
	@Test
	public void testRemoteControlLightsUndoWithOff() {
		RemoteControl remoteControl = new RemoteControl();
		Light light = new Light(); 
		remoteControl.setCommand(0, new LightOnCommand(light), new LightOffCommand(light));

		remoteControl.onButtonWasPushed(0);
		assertThat(light.isOn(), is(true));
		
		remoteControl.offButtonWasPushed(0);
		assertThat(light.isOn(), is(false));
		
		remoteControl.undoButtonWasPushed();
		assertThat(light.isOn(), is(true));
	}
	
	@Test
	public void testRemoteControlCeilingFanUndoWithPrevOff() {
		RemoteControl remoteControl = new RemoteControl();
		CeilingFan ceilingFan = new CeilingFan();
		remoteControl.setCommand(1, new CeilingFanHighCommand(ceilingFan), new CeilingFanLowCommand(ceilingFan));

		remoteControl.onButtonWasPushed(1);
		assertThat(ceilingFan.getSpeed(), is(Speed.HIGH));
		
		remoteControl.undoButtonWasPushed();
		assertThat(ceilingFan.getSpeed(), is(Speed.OFF));
	}	
	
	@Test
	public void testRemoteControlCeilingFanUndoWithPrevLow() {
		RemoteControl remoteControl = new RemoteControl();
		CeilingFan ceilingFan = new CeilingFan();
		remoteControl.setCommand(1, new CeilingFanHighCommand(ceilingFan), new CeilingFanLowCommand(ceilingFan));

		remoteControl.onButtonWasPushed(1);
		assertThat(ceilingFan.getSpeed(), is(Speed.HIGH));
		
		remoteControl.offButtonWasPushed(1);
		assertThat(ceilingFan.getSpeed(), is(Speed.LOW));
		
		remoteControl.undoButtonWasPushed();
		assertThat(ceilingFan.getSpeed(), is(Speed.HIGH));
	}	
	
	@Test
	public void testRemoteControlMacro() {
		RemoteControl remoteControl = new RemoteControl();
		Light hallLight = new Light();
		Command lightOnCommand = new LightOnCommand(hallLight);
		
		GarageDoor garageDoor = new GarageDoor();
		Command openGarageDoorCommand = new GarageDoorOpenCommand(garageDoor);
		
		Stereo stereo = new Stereo();
		Command stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
		
		CeilingFan ceilingFan = new CeilingFan();
		Command ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
		
		Command[] commands = { lightOnCommand, openGarageDoorCommand, stereoOnWithCDCommand, ceilingFanHighCommand };
		MacroCommand macroCommand = new MacroCommand(commands);
		
		
		remoteControl.setCommand(6, macroCommand, NoConfiguredCommand.INSTANCE);
		
		remoteControl.onButtonWasPushed(6);
		
		assertThat(hallLight.isOn(), is(true));
		assertThat(garageDoor.isDoorUp(), is(true));
		assertThat(ceilingFan.getSpeed(), is(Speed.HIGH));
		
	}
}
