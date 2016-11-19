package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Espresso extends Beverage {

	public Espresso() {
		this.description = "Espresso";
	}
	
	@Override
	public BigDecimal cost() {
		return new BigDecimal("1.25");
	}
}
