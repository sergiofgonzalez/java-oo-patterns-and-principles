package org.joolzminer.examples.patterns.runners;

import java.util.Scanner;

import org.joolzminer.examples.patterns.services.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherAppRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherAppRunner.class);
	
	private static WeatherData weatherData;
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		LOGGER.debug("Starting WeatherApp...");
		
		weatherData = new WeatherData();		
		scanner = new Scanner(System.in);
		
		eventLoop();	
		
		scanner.close();
		LOGGER.debug("Terminating WeatherApp.");

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
				weatherData.getCurrentConditionsDisplay().show();
				weatherData.getStatisticsDisplay().show();
				weatherData.getForecastDisplay().show();
				break;

			case "1":
				LOGGER.debug("Displaying current conditions");				
				weatherData.getCurrentConditionsDisplay().show();
				break;
				
			case "2":
				LOGGER.debug("displaying statistics");				
				weatherData.getStatisticsDisplay().show();
				break;

			case "3":
				LOGGER.debug("Displaying forecast");				
				weatherData.getForecastDisplay().show();
				break;
				
			case "q":
			case "Q":
				LOGGER.debug("Termination option received");				
				break;
				
			default:
				System.out.println("\nInvalid option selected");
		}
	}
}
