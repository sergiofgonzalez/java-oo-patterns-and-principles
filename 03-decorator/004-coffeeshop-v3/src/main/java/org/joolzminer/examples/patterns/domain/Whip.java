package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class Whip extends CondimentDecorator {

	public static final BigDecimal COST = new BigDecimal(.10);
	
	private Beverage wrappedBeverage;
	
	public Whip(Beverage beverage) {
		this.wrappedBeverage = beverage;
		this.size = wrappedBeverage.size;
	}
	
	@Override
	public String getDescription() {
		return wrappedBeverage.getDescription() + " with whip";

	}
	
	@Override
	public BigDecimal cost() {
		switch (size) {
			case TALL:
				return  wrappedBeverage.cost().add(COST);
			
			case GRANDE:
				return wrappedBeverage.cost().add(COST.add(new BigDecimal(0.05)));
		
			case VENTI:
				return wrappedBeverage.cost().add(COST.add(new BigDecimal(0.10)));
			
			default:
				throw new IllegalStateException("Unknown size " + size);
		}
	}
}
