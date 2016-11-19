package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class DarkRoast extends Beverage {

	public static final BigDecimal COST = new BigDecimal(".99");
	
	public DarkRoast() {
		this.description = "Dark roast coffee";
	}
	
	@Override
	public BigDecimal cost() {
		return COST;
	}
}
