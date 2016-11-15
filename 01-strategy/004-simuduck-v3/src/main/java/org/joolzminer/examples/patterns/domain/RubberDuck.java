package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.SqueakQuack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubberDuck extends Duck {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(RubberDuck.class);
	
	public RubberDuck() {
		this.quackBehavior = new SqueakQuack();
	}

	@Override
	public String display() {
		return "RubberDuck.display";
	}	
}
