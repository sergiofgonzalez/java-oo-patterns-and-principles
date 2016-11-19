package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		this.description = "DarkRoast";
	}
	
	@Override
	public BigDecimal cost() {
		return new BigDecimal("2.00");
	}
}
