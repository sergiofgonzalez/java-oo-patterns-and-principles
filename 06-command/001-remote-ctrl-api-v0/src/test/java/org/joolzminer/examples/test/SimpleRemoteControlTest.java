package org.joolzminer.examples.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.joolzminer.examples.patterns.SimpleRemoteControl;
import org.joolzminer.examples.patterns.command.Command;
import org.joolzminer.examples.patterns.command.GarageDoorOpenCommand;
import org.joolzminer.examples.patterns.command.LightOnCommand;
import org.joolzminer.examples.patterns.vendor.GarageDoor;
import org.joolzminer.examples.patterns.vendor.Light;
import org.junit.Test;

public class SimpleRemoteControlTest {

	@Test
	public void testSimpleRemoteControlLightOn() {

		/* Arrange */
		SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
		Light light = new Light(); 
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		simpleRemoteControl.setCommand(lightOnCommand);
		
		/* Act */
		simpleRemoteControl.buttonWasPressed();
		
		/* Assert */		
		assertThat(light.isOn(), is(true));
	}	
	
	@Test
	public void testSimpleRemoteControlGarageDoorUp() {

		/* Arrange */
		SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
		GarageDoor garageDoor = new GarageDoor();
		Command garageDoorUpCommand = new GarageDoorOpenCommand(garageDoor);
		simpleRemoteControl.setCommand(garageDoorUpCommand);
		
		/* Act */
		simpleRemoteControl.buttonWasPressed();
		
		/* Assert */		
		assertThat(garageDoor.isDoorUp(), is(true));
	}	
	
	@Test
	public void testSimpleRemoteControlrIsProgrammable() {

		/* Arrange */
		SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
		
		GarageDoor garageDoor = new GarageDoor();	
		Command garageDoorUpCommand = new GarageDoorOpenCommand(garageDoor);

		Light light = new Light();
		Command lightOnCommand = new LightOnCommand(light);
		
		/* Act */
		simpleRemoteControl.setCommand(garageDoorUpCommand);
		boolean garageDoorIsUpBefore = garageDoor.isDoorUp();
		simpleRemoteControl.buttonWasPressed();
		boolean garageDoorIsUpAfter = garageDoor.isDoorUp();
		
		simpleRemoteControl.setCommand(lightOnCommand);
		boolean lightIsOnBefore = light.isOn();
		simpleRemoteControl.buttonWasPressed();
		boolean lightIsOnAfter= light.isOn();
		
		
		/* Assert */		
		assertThat(garageDoorIsUpBefore, is(false));
		assertThat(garageDoorIsUpAfter, is(true));
		assertThat(lightIsOnBefore, is(false));
		assertThat(lightIsOnAfter, is(true));
	}		
}
