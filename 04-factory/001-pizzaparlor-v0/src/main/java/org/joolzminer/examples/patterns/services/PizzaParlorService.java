package org.joolzminer.examples.patterns.services;

import org.joolzminer.examples.patterns.domain.CheesePizza;
import org.joolzminer.examples.patterns.domain.GreekPizza;
import org.joolzminer.examples.patterns.domain.PepperoniPizza;
import org.joolzminer.examples.patterns.domain.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PizzaParlorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PizzaParlorService.class);
	
	public Pizza orderPizza(String type) {
		LOGGER.debug("An order for a pizza pie with type = {} has been received", type);
		
		Pizza pizza;
		
		switch (type) {
			case "cheese":
				pizza = new CheesePizza();
				break;
				
			case "greek":
				pizza = new GreekPizza();
				break;
			
			case "pepperoni":
				pizza = new PepperoniPizza();
				break;
			
			default:
				throw new IllegalArgumentException("Unknown pizza type: " + type);
		}
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		LOGGER.debug("Pizza type = {} preparation has been completed", type);
		return pizza;
	}
}
