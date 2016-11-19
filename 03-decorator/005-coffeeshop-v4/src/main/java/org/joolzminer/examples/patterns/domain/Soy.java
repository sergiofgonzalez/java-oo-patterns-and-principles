package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Soy extends CondimentDecorator {

	public static final BigDecimal COST = new BigDecimal(.20);
		
	public Soy(Beverage beverage) {
		this.cost = COST;
		this.wrappedBeverage = beverage;
		this.size = wrappedBeverage.size;
	}
	
	@Override
	public String getDescription() {
		return wrappedBeverage.getDescription() + " with soy";

	}
}
