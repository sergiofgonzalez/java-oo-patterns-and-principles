package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Milk extends CondimentDecorator {

	public static final BigDecimal COST = new BigDecimal(.10);
	
	public Milk(Beverage beverage) {
		this.cost = COST;
		this.wrappedBeverage = beverage;
		this.size = wrappedBeverage.size;
	}
	
	@Override
	public String getDescription() {
		return wrappedBeverage.getDescription() + " with steamed milk";

	}
}
