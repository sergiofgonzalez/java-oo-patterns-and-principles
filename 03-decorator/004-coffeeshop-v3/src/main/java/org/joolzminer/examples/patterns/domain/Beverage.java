package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public abstract class Beverage {

	public enum Size { TALL, GRANDE, VENTI };
	
	protected String description;
	protected Size size = Size.TALL;

	public String getDescription() {
		return description;
	}
			
	public Size getSize() {
		return size;
	}
	
	public abstract BigDecimal cost();
}
