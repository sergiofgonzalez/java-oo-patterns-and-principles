package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Decaf extends Beverage {

	public static final BigDecimal COST = new BigDecimal("1.05");
	
	public Decaf() {
		this.description = "Decaf";
	}
	
	@Override
	public BigDecimal cost() {
		return COST;
	}
}
