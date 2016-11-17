package org.joolzminer.examples.patterns.displays;

import java.text.NumberFormat;

import org.joolzminer.examples.patterns.observer.Subject;

public class CurrentConditionsDisplay extends Display {

	public CurrentConditionsDisplay(Subject subject) {
		super(subject);
	}

	@Override
	public void show() {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
		System.out.println("================= CURRENT CONDITIONS ============");
		System.out.println(" Temperature: " + numberFormat.format(this.temperature));
		System.out.println(" Pressure   : " + numberFormat.format(this.pressure));
		System.out.println(" Humidity   : " + numberFormat.format(this.humidity));
		System.out.println("================= CURRENT CONDITIONS ============");		
	}
}
