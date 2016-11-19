package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Soy extends CondimentDecorator {

	public static final BigDecimal COST = new BigDecimal(.15);
	
	private Beverage wrappedBeverage;
	
	public Soy(Beverage beverage) {
		this.wrappedBeverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return wrappedBeverage.getDescription() + " with soy";

	}
	
	@Override
	public BigDecimal cost() {
		return wrappedBeverage.cost().add(COST);
	}
}
