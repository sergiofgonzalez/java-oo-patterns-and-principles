package org.joolzminer.examples.patterns.services;

import org.joolzminer.examples.patterns.domain.Pizza;
import org.joolzminer.examples.patterns.factories.PizzaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PizzaParlorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PizzaParlorService.class);
	
	private PizzaFactory pizzaFactory;
	
	public PizzaParlorService(PizzaFactory pizzaFactory) {
		this.pizzaFactory = pizzaFactory;
	}
	
	public Pizza orderPizza(String type) {
		LOGGER.debug("An order for a pizza pie with type = {} has been received", type);
		
		Pizza pizza = pizzaFactory.createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		LOGGER.debug("Pizza type = {} preparation has been completed", type);
		return pizza;
	}
}
