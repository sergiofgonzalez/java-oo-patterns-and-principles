package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.BasicQuack;
import org.joolzminer.examples.patterns.domain.behaviors.FlyWithWings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedHeadDuck extends Duck {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(RedHeadDuck.class);
	
	public RedHeadDuck() {
		this.flyBehavior = new FlyWithWings();
		this.quackBehavior = new BasicQuack();
	}
	
	@Override
	public String display() {
		return "RedHeadDuck.display";
	}
}
