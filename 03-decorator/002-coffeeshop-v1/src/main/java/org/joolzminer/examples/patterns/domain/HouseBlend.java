package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		this.description = "HouseBlend";
	}
	
	@Override
	public BigDecimal cost() {
		return new BigDecimal("1.50");
	}
}
