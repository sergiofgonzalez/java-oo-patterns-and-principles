package org.joolzminer.examples.patterns.services;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.joolzminer.examples.patterns.displays.CurrentConditionsDisplay;
import org.joolzminer.examples.patterns.displays.Display;
import org.joolzminer.examples.patterns.displays.ForecastDisplay;
import org.joolzminer.examples.patterns.displays.StatisticsDisplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherData {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherData.class);
	
	private Display currentConditionsDisplay;
	private Display statisticsDisplay;
	private Display forecastDisplay;

	public WeatherData() {
		currentConditionsDisplay = new CurrentConditionsDisplay();
		statisticsDisplay = new StatisticsDisplay();
		forecastDisplay = new ForecastDisplay();
		
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
		double latestTemperature = getTemperature();
		double latestHumidity = getHumidity();
		double latestPressure = getPressure();
		
		currentConditionsDisplay.update(latestTemperature, latestHumidity, latestPressure);
		statisticsDisplay.update(latestTemperature, latestHumidity, latestPressure);
		forecastDisplay.update(latestTemperature, latestHumidity, latestPressure);
	}

	public Display getCurrentConditionsDisplay() {
		return currentConditionsDisplay;
	}

	public Display getStatisticsDisplay() {
		return statisticsDisplay;
	}

	public Display getForecastDisplay() {
		return forecastDisplay;
	}	
}
