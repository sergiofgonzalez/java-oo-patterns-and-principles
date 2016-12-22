package org.joolzminer.examples.patterns.runner;

import org.joolzminer.examples.patterns.facade.HomeTheaterFacade;
import org.joolzminer.examples.patterns.facade.vendor.Amplifier;
import org.joolzminer.examples.patterns.facade.vendor.DvdPlayer;
import org.joolzminer.examples.patterns.facade.vendor.PopcornPopper;
import org.joolzminer.examples.patterns.facade.vendor.Projector;
import org.joolzminer.examples.patterns.facade.vendor.Screen;
import org.joolzminer.examples.patterns.facade.vendor.TheaterLights;

public class HomeTheaterRunner {

	public static void main(String[] args) {
		Amplifier amplifier = new Amplifier();
		DvdPlayer dvdPlayer = new DvdPlayer(amplifier);
		
		
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(new PopcornPopper(), new TheaterLights(), new Screen(), new Projector(dvdPlayer), amplifier, dvdPlayer);
		homeTheaterFacade.watchMovie();		
	}
}
