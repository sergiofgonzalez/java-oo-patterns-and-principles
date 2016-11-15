package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.QuackBehavior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubberDuck extends Duck {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(RubberDuck.class);
	
	private QuackBehavior quackBehavior;
	
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	@Override
	public String display() {
		return "RubberDuck.display";
	}

	public String squeak() {
		return quackBehavior.quack();
	}	
}
