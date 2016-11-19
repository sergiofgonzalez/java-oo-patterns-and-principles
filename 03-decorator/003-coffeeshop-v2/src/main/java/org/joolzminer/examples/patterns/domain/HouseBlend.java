package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class HouseBlend extends Beverage {

	public static final BigDecimal COST = new BigDecimal(".89");
	
	public HouseBlend() {
		this.description = "House blend coffee";
	}
	
	@Override
	public BigDecimal cost() {
		return COST;
	}
}
