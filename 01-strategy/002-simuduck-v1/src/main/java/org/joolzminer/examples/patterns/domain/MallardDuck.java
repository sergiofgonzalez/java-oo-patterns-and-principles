package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.Flyable;
import org.joolzminer.examples.patterns.domain.behaviors.Quackable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MallardDuck extends Duck implements Quackable, Flyable {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(MallardDuck.class);
	
	@Override
	public String display() {
		return "MallardDuck.display";
	}

	@Override
	public String fly() {
		return "MallardDuck.fly";
	}

	@Override
	public String quack() {
		return "MallardDuck.quack";
	}
}
