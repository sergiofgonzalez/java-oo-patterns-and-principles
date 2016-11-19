package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Milk extends CondimentDecorator {

	public static final BigDecimal COST = new BigDecimal(.10);
	
	private Beverage wrappedBeverage;
	
	public Milk(Beverage beverage) {
		this.wrappedBeverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return wrappedBeverage.getDescription() + " with steamed milk";

	}
	
	@Override
	public BigDecimal cost() {
		return wrappedBeverage.cost().add(COST);
	}
}
