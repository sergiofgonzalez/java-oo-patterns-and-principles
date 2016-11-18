package org.joolzminer.examples.patterns.displays;


import java.util.Observable;
import java.util.Observer;

import org.joolzminer.examples.patterns.services.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Display implements Observer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Display.class);
	
	private Observable observable;
	
	protected double temperature;
	protected double humidity;
	protected double pressure;

	public Display(Observable observable) {
		this.observable = observable;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		LOGGER.debug("An update action has been received");

		if (observable instanceof WeatherData) {
			LOGGER.debug("Update action is WeatherData related: before state: temperature={}, humidity={}, pressure={}", this.temperature, this.humidity, this.pressure);
			WeatherData weatherData = (WeatherData) observable;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			LOGGER.debug("An update action has been completed: after state: temperature={}, humidity={}, pressure={}", this.temperature, this.humidity, this.pressure);				
		}
	}



	public abstract void show();
	
	public void deRegisterSelf() {
		observable.deleteObserver(this);
	}
}
