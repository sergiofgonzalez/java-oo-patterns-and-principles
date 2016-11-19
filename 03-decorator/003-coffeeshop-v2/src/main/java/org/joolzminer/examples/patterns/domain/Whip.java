package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Whip extends CondimentDecorator {

	public static final BigDecimal COST = new BigDecimal(.10);
	
	private Beverage wrappedBeverage;
	
	public Whip(Beverage beverage) {
		this.wrappedBeverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return wrappedBeverage.getDescription() + " with whip";

	}
	
	@Override
	public BigDecimal cost() {
		return wrappedBeverage.cost().add(COST);
	}
}
