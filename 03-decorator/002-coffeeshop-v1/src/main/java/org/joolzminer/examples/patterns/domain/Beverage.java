package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public abstract class Beverage {

	protected String description;
	private boolean milk;
	private boolean soy;
	private boolean mocha;
	private boolean whip;

	public String getDescription() {
		return description;
	}
		
	public boolean hasMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	public boolean hasSoy() {
		return soy;
	}

	public void setSoy(boolean soy) {
		this.soy = soy;
	}

	public boolean hasMocha() {
		return mocha;
	}

	public void setMocha(boolean mocha) {
		this.mocha = mocha;
	}

	public boolean hasWhip() {
		return whip;
	}

	public void setWhip(boolean whip) {
		this.whip = whip;
	}

	protected BigDecimal getCondimentsPrice() {
		BigDecimal condimentsPrice = BigDecimal.ZERO;
		if (hasMilk()) {
			condimentsPrice.add(new BigDecimal("0.10"));
		}
		
		if (hasSoy()) {
			condimentsPrice.add(new BigDecimal("0.05"));
		}
		
		if (hasMocha()) {
			condimentsPrice.add(new BigDecimal("0.25"));
		}
		
		if (hasWhip()) {
			condimentsPrice.add(new BigDecimal("0.50"));
		}
		return condimentsPrice;
	}
	
	public abstract BigDecimal cost();
}
