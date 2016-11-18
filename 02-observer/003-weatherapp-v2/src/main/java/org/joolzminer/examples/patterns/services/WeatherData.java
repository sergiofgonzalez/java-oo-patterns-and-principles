package org.joolzminer.examples.patterns.services;

import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherData extends Observable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherData.class);
	
	private double temperature;
	private double humidity;
	private double pressure;
	
	public WeatherData() {
		/* update measurements every 30 secs */
		Timer timer = new Timer();		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				measurementsChanged();
			}
		}, 0, 30 * 1000);
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public double getHumidity() {
		return humidity;
	}
	
	public double getPressure() {
		return pressure;
	}
	
	private void acquireTemperature() {
		LOGGER.debug("Contacting Internet service to acquire current temperature...");
		
		double acquiredTemperature = (new Random().nextDouble() * 49.0) - 7.0; /* random between -7 and 42 */
		
		LOGGER.debug("Current temperature={}", acquiredTemperature);
		this.temperature = acquiredTemperature;
	}
	
	private void acquireHumidity() {
		LOGGER.debug("Contacting Internet service to acquire current humidity...");
		
		double acquiredHumidity = (new Random().nextDouble() * 25.0) + 75.0; /* random between -75 and 100 */
		
		LOGGER.debug("Current humidity={}", acquiredHumidity);
		this.temperature = acquiredHumidity;

	}
	
	private void acquirePressure() {
		LOGGER.debug("Contacting Internet service to acquire current pressure...");
		
		double acquiredPressure = (new Random().nextDouble() * 0.40) + 29.80; /* random between 29.80 and 30.20 */
		
		LOGGER.debug("Current pressure={}", acquiredPressure);
		this.pressure = acquiredPressure;
	}
	
	/* This method gets called whenever the weather measurements have been updated */
	public void measurementsChanged() {
		LOGGER.debug("A measurements changed signal has been received: notifying registered observers!");
		
		acquireTemperature();
		acquirePressure();
		acquireHumidity();
		
		setChanged();
	}
}
