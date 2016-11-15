package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.FlyBehavior;
import org.joolzminer.examples.patterns.domain.behaviors.QuackBehavior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Duck {

	private static final Logger LOGGER = LoggerFactory.getLogger(Duck.class);
	
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public String swim() {
		return "Duck.swim";
	}
	
	public abstract String display();
	
	public String fly() {
		if (flyBehavior != null) {
			return flyBehavior.fly();
		} else {
			LOGGER.error("FlyBehavior was not set for this instance: {}", this.display());
			throw new UnsupportedOperationException("FlyBehavior was not set for this instance");
		}
	}
	
	public String quack() {
		if (quackBehavior != null) {
			return quackBehavior.quack();
		} else {
			LOGGER.error("QuackBehavior was not set for this instance: {}", this.display());
			throw new UnsupportedOperationException("QuackBehavior was not set for this instance");
		}
	}
}
