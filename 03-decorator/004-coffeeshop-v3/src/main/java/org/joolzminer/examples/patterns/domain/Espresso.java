package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Espresso extends Beverage {

	public static final BigDecimal COST = new BigDecimal(".89");
	
	public Espresso(Size size) {
		this.size = size;
		this.description = this.size + " Espresso";
	}
	
	@Override
	public BigDecimal cost() {
		switch (size) {
			case TALL:
				return COST;

			case GRANDE:
				return COST.add(new BigDecimal(".10"));
				
			case VENTI:
				return COST.add(new BigDecimal(".15"));
			
			default:
				throw new IllegalStateException("Unknown size " + size);
		}
	}
}
