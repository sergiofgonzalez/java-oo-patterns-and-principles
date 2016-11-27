package org.joolzminer.examples.patterns.runner;

import org.joolzminer.examples.patterns.domain.Pizza;
import org.joolzminer.examples.patterns.services.PizzaParlorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PizzaParlorRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(PizzaParlorRunner.class); 
	
	public static void main(String[] args) {
		PizzaParlorService pizzaParlorService = new PizzaParlorService();
		
		Pizza pizza = pizzaParlorService.orderPizza("cheese");
		LOGGER.debug("A cheese pizza order has been completed: {}", pizza.getDescription());
	}
}
