package org.joolzminer.examples.patterns.services;

import org.joolzminer.examples.patterns.domain.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PizzaParlor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PizzaParlor.class);
		
	public Pizza orderPizza(String type) {
		LOGGER.debug("An order for a pizza pie with type = {} has been received", type);
		
		Pizza pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		LOGGER.debug("Pizza type = {} preparation has been completed", type);
		return pizza;
	}
	
	public abstract Pizza createPizza(String type);
}
