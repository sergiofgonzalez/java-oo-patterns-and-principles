package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Decaf extends Beverage {

	public Decaf() {
		this.description = "Decaf";
	}
	
	@Override
	public BigDecimal cost() {
		return new BigDecimal("1.40");
	}
}
