package org.joolzminer.examples.patterns.displays.external;

import java.text.NumberFormat;

import org.joolzminer.examples.patterns.displays.Display;
import org.joolzminer.examples.patterns.observer.Subject;

public class FeelsLikeDisplay extends Display {

	private boolean isNotEnoughData;
	
	public FeelsLikeDisplay(Subject subject) {
		super(subject);
		isNotEnoughData = true;
	}

	
	
	@Override
	public void update(double temperature, double humidity, double pressure) {
		if (isNotEnoughData) {
			isNotEnoughData = false;
		}
		super.update(temperature, humidity, pressure);
	}



	@Override
	public void show() {
		System.out.println("================= FEELS LIKE=====================");
		if (isNotEnoughData) {
			System.out.println("Not enough data: waiting for measurements update");
		} else {
			if (this.humidity > 90.0) {
				if (this.temperature >= 20.0) {
					System.out.println("Temperature is " + formatMeasurement(temperature) + " °C, but it feels like " + formatMeasurement(temperature + temperature * 0.15) + " °C");
				} else {
					System.out.println("Temperature is " + formatMeasurement(temperature) + "°C, but it feels like " + formatMeasurement(temperature - temperature * 0.15) + " °C");
				}
			} else {
				System.out.println("Temperature is " + formatMeasurement(temperature) + "°C");
			}	
		}
		System.out.println("=================================================");		
	}
	
	private static String formatMeasurement(double measurement) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
		
		return numberFormat.format(measurement);
	}

}
