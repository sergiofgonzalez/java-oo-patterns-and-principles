package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public abstract class Beverage {

	public enum Size { TALL, GRANDE, VENTI };
	
	protected BigDecimal cost;
	protected String description;
	protected Size size = Size.TALL;

	public String getDescription() {
		return description;
	}
			
	public Size getSize() {
		return size;
	}
	
	public BigDecimal cost() {
		switch (size) {
			case TALL:
				return cost;

			case GRANDE:
				return cost.add(new BigDecimal(".10"));
				
			case VENTI:
				return cost.add(new BigDecimal(".15"));
			
			default:
				throw new IllegalStateException("Unknown size " + size);
		}
	}
}
