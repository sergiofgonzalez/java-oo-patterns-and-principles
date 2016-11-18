package org.joolzminer.examples.patterns.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.joolzminer.examples.patterns.observer.Observer;
import org.joolzminer.examples.patterns.observer.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherData implements Subject {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherData.class);
	
	private List<Observer> observers;

	public WeatherData() {
		observers = new ArrayList<>();
		
		/* update measurements every 30 secs */
		Timer timer = new Timer();		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				measurementsChanged();
			}
		}, 0, 30 * 1000);
	}
	
	private static double getTemperature() {
		LOGGER.debug("Contacting Internet service to retrieve current temperature...");
		
		double currentTemperature = (new Random().nextDouble() * 49.0) - 7.0; /* random between -7 and 42 */
		
		LOGGER.debug("Current temperature={}", currentTemperature);
		return currentTemperature;
	}
	
	private static double getHumidity() {
		LOGGER.debug("Contacting Internet service to retrieve current humidity...");
		
		double currentHumidity = (new Random().nextDouble() * 25.0) + 75.0; /* random between -75 and 100 */
		
		LOGGER.debug("Current humidity={}", currentHumidity);
		return currentHumidity;

	}
	
	private static double getPressure() {
		LOGGER.debug("Contacting Internet service to retrieve current pressure...");
		
		double currentPressure = (new Random().nextDouble() * 0.40) + 29.80; /* random between 29.80 and 30.20 */
		
		LOGGER.debug("Current pressure={}", currentPressure);
		return currentPressure;
	}
	
	/* This method gets called whenever the weather measurements have been updated */
	public void measurementsChanged() {
		LOGGER.debug("A measurements changed signal has been received!");
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		LOGGER.debug("A request to notify servers");
		double latestTemperature = getTemperature();
		double latestHumidity = getHumidity();
		double latestPressure = getPressure();
		
		observers.stream().forEach(observer -> observer.update(latestTemperature, latestHumidity, latestPressure));
	}	
}
