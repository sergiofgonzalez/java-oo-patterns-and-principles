package org.joolzminer.examples.patterns.displays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForecastDisplay extends Display {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(ForecastDisplay.class);
	
	private double prevTemperature;
	private double prevPressure;
	private double prevHumidity;
	
			
	@Override
	public void update(double temperature, double humidity, double pressure) {
		this.prevTemperature = this.temperature;
		this.prevPressure = this.pressure;
		this.prevHumidity = this.humidity;
		
		super.update(temperature, humidity, pressure);
	}


	@Override
	public void show() {		
		System.out.println("================= FORECAST ======================");
		System.out.println(" Temperature: " + getForecastForMeasurement(prevTemperature, temperature));
		System.out.println(" Pressure   : " + getForecastForMeasurement(prevPressure, pressure));
		System.out.println(" Humidity   : " + getForecastForMeasurement(prevHumidity, humidity));
		System.out.println("=================================================");		
	}
		
	private String getForecastForMeasurement(double prevValue, double currentValue) {
		if (currentValue > prevValue) {
			return "↑";
		} else if (currentValue == prevValue) {
			return "↔";			
		} else {
			return "↓";
		}
	}
}
