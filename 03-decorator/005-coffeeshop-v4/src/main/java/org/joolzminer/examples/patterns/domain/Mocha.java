package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Mocha extends CondimentDecorator {

	public static final BigDecimal COST = new BigDecimal(.15);
		
	public Mocha(Beverage beverage) {
		this.cost = COST;
		this.wrappedBeverage = beverage;
		this.size = wrappedBeverage.size;
	}
	
	@Override
	public String getDescription() {
		return wrappedBeverage.getDescription() + " with mocha";

	}
}
