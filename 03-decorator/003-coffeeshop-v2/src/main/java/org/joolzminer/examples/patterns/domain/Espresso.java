package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Espresso extends Beverage {

	public static final BigDecimal COST = new BigDecimal(".89");
	
	public Espresso() {
		this.description = "Espresso";
	}
	
	@Override
	public BigDecimal cost() {
		return COST;
	}
}
