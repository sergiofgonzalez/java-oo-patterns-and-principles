package org.joolzminer.examples.patterns.facade;

import org.joolzminer.examples.patterns.facade.vendor.Amplifier;
import org.joolzminer.examples.patterns.facade.vendor.DvdPlayer;
import org.joolzminer.examples.patterns.facade.vendor.PopcornPopper;
import org.joolzminer.examples.patterns.facade.vendor.Projector;
import org.joolzminer.examples.patterns.facade.vendor.Screen;
import org.joolzminer.examples.patterns.facade.vendor.TheaterLights;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeTheaterFacade {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeTheaterFacade.class);
	
	private PopcornPopper popcornPopper;
	private TheaterLights theaterLights;
	private Screen screen;
	private Projector projector;
	private Amplifier amplifier;
	private DvdPlayer dvdPlayer;

	public HomeTheaterFacade(PopcornPopper popcornPopper, TheaterLights theaterLights, Screen screen, Projector projector, Amplifier amplifier, DvdPlayer dvdPlayer) {
		this.popcornPopper = popcornPopper;
		this.theaterLights = theaterLights;
		this.screen = screen;
		this.projector = projector;
		this.amplifier = amplifier;
		this.dvdPlayer = dvdPlayer;
	}
	
	
	public void watchMovie() {
		LOGGER.debug("Initiating actions for watchMovie");
		popcornPopper.on();
		popcornPopper.pop();
		
		theaterLights.on();
		theaterLights.dim();
		
		screen.down();
		
		projector.on();
		projector.dvdMode();
		
		amplifier.on();
		amplifier.setDvdModeOn();
		if (!amplifier.isSurroundModeOn()) {
			amplifier.surroundModeSwitch();
		}
		amplifier.setVolume(11);
		
		dvdPlayer.on();
		dvdPlayer.play();
	}
	
	public void endMovie() {
		LOGGER.debug("Initiating actions for endMovie");		
		popcornPopper.off();
		dvdPlayer.off();
		amplifier.off();
		theaterLights.off();
		projector.off();		
		screen.up();
	}
}
