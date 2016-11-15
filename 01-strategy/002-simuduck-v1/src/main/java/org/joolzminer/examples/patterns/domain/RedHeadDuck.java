package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.Flyable;
import org.joolzminer.examples.patterns.domain.behaviors.Quackable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedHeadDuck extends Duck implements Quackable, Flyable {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(RedHeadDuck.class);
	
	@Override
	public String display() {
		return "RedHeadDuck.display";
	}

	@Override
	public String fly() {
		return "RedHeadDuck.fly";
	}

	@Override
	public String quack() {
		return "RedHeadDuck.quack";
	}

}
