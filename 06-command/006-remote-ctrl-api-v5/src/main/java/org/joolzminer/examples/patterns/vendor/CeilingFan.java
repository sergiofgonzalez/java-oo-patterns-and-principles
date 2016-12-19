package org.joolzminer.examples.patterns.vendor;

public class CeilingFan {
	public enum Speed { OFF, LOW, MEDIUM, HIGH };
	
	private Speed speed;
	
	public CeilingFan() {
		this.speed = Speed.OFF;
	}
	
	public void off() {
		this.speed = Speed.OFF;
	}
	
	public void low() {
		this.speed = Speed.LOW;
	}
	
	public void medium() {
		this.speed = Speed.MEDIUM;
	}
	
	public void high() {
		this.speed = Speed.HIGH;
	}

	public Speed getSpeed() {
		return speed;
	}

	@Override
	public String toString() {
		return "CeilingFan [speed=" + speed + "]";
	}	
}
