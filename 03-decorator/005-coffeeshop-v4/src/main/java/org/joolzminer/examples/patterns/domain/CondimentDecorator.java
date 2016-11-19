package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public abstract class CondimentDecorator extends Beverage {

	protected Beverage wrappedBeverage;
	
	public abstract String getDescription();
	
	@Override
	public BigDecimal cost() {
		switch (size) {
			case TALL:
				return  wrappedBeverage.cost().add(cost);
			
			case GRANDE:
				return wrappedBeverage.cost().add(cost.add(new BigDecimal(0.05)));
		
			case VENTI:
				return wrappedBeverage.cost().add(cost.add(new BigDecimal(0.10)));
			
			default:
				throw new IllegalStateException("Unknown size " + size);
		}
	}
}
