package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class DarkRoast extends Beverage {

	public static final BigDecimal COST = new BigDecimal(".99");
	
	public DarkRoast(Size size) {
		this.cost = COST;
		this.size = size;
		description = this.size + " Dark roast coffee";
	}
	

}
