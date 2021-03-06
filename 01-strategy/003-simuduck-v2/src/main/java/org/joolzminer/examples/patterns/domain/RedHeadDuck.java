package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.FlyBehavior;
import org.joolzminer.examples.patterns.domain.behaviors.QuackBehavior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedHeadDuck extends Duck {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(RedHeadDuck.class);
	
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;
		
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	@Override
	public String display() {
		return "RedHeadDuck.display";
	}

	public String fly() {
		return flyBehavior.fly();
	}

	public String quack() {
		return quackBehavior.quack();
	}

}
