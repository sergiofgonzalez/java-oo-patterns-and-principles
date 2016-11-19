package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class HouseBlend extends Beverage {

	public static final BigDecimal COST = new BigDecimal(".89");
	
	public HouseBlend(Size size) {
		this.cost = COST;
		this.size = size;
		this.description = this.size + " House blend coffee";
	}
}
