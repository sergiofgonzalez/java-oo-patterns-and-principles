package org.joolzminer.examples.patterns.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.joolzminer.examples.patterns.displays.CurrentConditionsDisplay;
import org.joolzminer.examples.patterns.displays.Display;
import org.joolzminer.examples.patterns.displays.ForecastDisplay;
import org.joolzminer.examples.patterns.displays.StatisticsDisplay;
import org.joolzminer.examples.patterns.displays.external.FeelsLikeDisplay;
import org.joolzminer.examples.patterns.services.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherAppRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherAppRunner.class);
	
	private static WeatherData weatherData;
	private static Display currentConditionsDisplay;
	private static Display statisticsDisplay;
	private static Display forecastDisplay;
	
	private static List<Display> displays;
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		LOGGER.debug("Starting WeatherApp...");
		
		handleInitialization();
		
		eventLoop();	

		handleTermination();
		

		LOGGER.debug("Terminating WeatherApp.");

	}

	private static void handleInitialization() {
		/* bootstrap the weather data object */
		weatherData = new WeatherData();
		
		/* create the screens */
		currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		statisticsDisplay = new StatisticsDisplay(weatherData);
		forecastDisplay = new ForecastDisplay(weatherData);
		
		displays = new ArrayList<>();
		displays.addAll(Arrays.asList(currentConditionsDisplay, statisticsDisplay, forecastDisplay));
		
		/* register the screens as observers */
		weatherData.registerObserver(currentConditionsDisplay);
		weatherData.registerObserver(statisticsDisplay);
		weatherData.registerObserver(forecastDisplay);		
		
		/* initialize the Scanner used to read user input */
		scanner = new Scanner(System.in);
	}
	
	private static void eventLoop() {
		String userInput;
		do {
			showMenu();
			userInput = getUserInput();
			handleUserAction(userInput);
		} while (!userInput.equalsIgnoreCase("q"));		
	}
	
	private static void showMenu() {
		System.out.println("Options: ");
		System.out.println(" 1: Show current measurements");
		System.out.println(" 2: Show statistics");
		System.out.println(" 3: Show forecast");
		System.out.println(" 4: Enable Feels like plugin");
		System.out.println(" 0: Show all");
		System.out.println(" q: Quit");
		System.out.print("Enter your option: ");
	}
	
	private static String getUserInput() {
		String userInput = scanner.next();
		return userInput;
	}
	
	private static void handleUserAction(String userInput) {
		switch (userInput) {
			case "0":
				LOGGER.debug("Displaying all screens");
				displays.forEach(Display::show);
				break;

			case "1":
				LOGGER.debug("Displaying current conditions");				
				currentConditionsDisplay.show();
				break;
				
			case "2":
				LOGGER.debug("displaying statistics");				
				statisticsDisplay.show();
				break;

			case "3":
				LOGGER.debug("Displaying forecast");				
				forecastDisplay.show();
				break;
				
			case "4":
				LOGGER.debug("Enabling 'Feels like' plugin");
				Display feelsLikeDisplay = new FeelsLikeDisplay(weatherData);
				weatherData.registerObserver(feelsLikeDisplay);
				displays.add(feelsLikeDisplay);
				break;
				
			case "q":
			case "Q":
				LOGGER.debug("Termination option received");				
				break;
				
			default:
				System.out.println("\nInvalid option selected");
		}
	}
	
	private static void handleTermination() {
		
		/* close the scanner used to read user input */
		scanner.close();
		
		/* deregister the observers from the subject */
		weatherData.removeObserver(currentConditionsDisplay);
		weatherData.removeObserver(statisticsDisplay);
		weatherData.removeObserver(forecastDisplay);				
	}
}
