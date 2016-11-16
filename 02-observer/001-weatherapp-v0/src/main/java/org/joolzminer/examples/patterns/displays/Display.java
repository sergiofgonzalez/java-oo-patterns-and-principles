package org.joolzminer.examples.patterns.displays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Display {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Display.class);
	
	protected double temperature;
	protected double humidity;
	protected double pressure;
	
	public void update(double temperature, double humidity, double pressure) {
		LOGGER.debug("An update action has been received: before state: temperature={}, humidity={}, pressure={}", this.temperature, this.humidity, this.pressure);
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;		
		LOGGER.debug("An update action has been received: after state: temperature={}, humidity={}, pressure={}", this.temperature, this.humidity, this.pressure);		
	}
	
	public abstract void show();
}
