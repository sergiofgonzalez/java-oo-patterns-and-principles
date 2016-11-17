package org.joolzminer.examples.patterns.displays;

import org.joolzminer.examples.patterns.observer.Observer;
import org.joolzminer.examples.patterns.observer.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Display implements Observer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Display.class);
	
	private Subject subject;
	
	protected double temperature;
	protected double humidity;
	protected double pressure;

	public Display(Subject subject) {
		this.subject = subject;
	}
	
	@Override
	public void update(double temperature, double humidity, double pressure) {
		LOGGER.debug("An update action has been received: before state: temperature={}, humidity={}, pressure={}", this.temperature, this.humidity, this.pressure);
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;		
		LOGGER.debug("An update action has been received: after state: temperature={}, humidity={}, pressure={}", this.temperature, this.humidity, this.pressure);		
	}
	
	public abstract void show();
	
	public void deRegisterSelf() {
		subject.removeObserver(this);
	}
}
