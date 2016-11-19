package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Mocha extends CondimentDecorator {

	public static final BigDecimal COST = new BigDecimal(.20);
	
	private Beverage wrappedBeverage;
	
	public Mocha(Beverage beverage) {
		this.wrappedBeverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return wrappedBeverage.getDescription() + " with mocha";

	}
	
	@Override
	public BigDecimal cost() {
		return wrappedBeverage.cost().add(COST);
	}
}
