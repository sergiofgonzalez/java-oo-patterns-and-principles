package org.joolzminer.examples.patterns.displays;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joolzminer.examples.patterns.observer.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatisticsDisplay extends Display {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsDisplay.class);
	
	private List<Double> historyTemperatureMeasurements;
	private List<Double> historyPressureMeasurements;
	private List<Double> historyHumidityMeasurements;
	
	
	public StatisticsDisplay(Subject subject) {
		super(subject);
		historyTemperatureMeasurements = new ArrayList<>();
		historyPressureMeasurements = new ArrayList<>();
		historyHumidityMeasurements = new ArrayList<>();
	}
	
		
	@Override
	public void update(double temperature, double humidity, double pressure) {
		super.update(temperature, humidity, pressure);
		historyTemperatureMeasurements.add(temperature);
		historyHumidityMeasurements.add(humidity);
		historyPressureMeasurements.add(pressure);
	}


	@Override
	public void show() {		
		System.out.println("================= STATISTICS ====================");
		System.out.println(" Temperature: " + getStatisticsLineForMeasurement(historyTemperatureMeasurements));
		System.out.println(" Pressure   : " + getStatisticsLineForMeasurement(historyPressureMeasurements));
		System.out.println(" Humidity   : " + getStatisticsLineForMeasurement(historyHumidityMeasurements));
		System.out.println("=================================================");		
	}
	
	private static double min(List<Double> measurements) {
		return Collections.min(measurements);
	}
	
	private static double max(List<Double> measurements) {
		return Collections.max(measurements);
	}
	
	private static double avg(List<Double> measurements) {
		int numMeasurements = measurements.size();
		double sum = measurements.stream().reduce(0.0, (acc, item) -> acc + item);
		return sum / numMeasurements;
	}
	
	private static String getStatisticsLineForMeasurement(List<Double> measurements) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
		
		return String.format("min=%s, max=%s, avg=%s", numberFormat.format(min(measurements)), numberFormat.format(max(measurements)), numberFormat.format(avg(measurements)));
	}
}
