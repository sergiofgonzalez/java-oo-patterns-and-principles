package org.joolzminer.examples.patterns.factories;

import org.joolzminer.examples.patterns.domain.CheesePizza;
import org.joolzminer.examples.patterns.domain.GreekPizza;
import org.joolzminer.examples.patterns.domain.PepperoniPizza;
import org.joolzminer.examples.patterns.domain.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplePizzaFactory implements PizzaFactory {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SimplePizzaFactory.class);
	
	@Override
	public Pizza createPizza(String type) {
		LOGGER.debug("Received message to instantiate a {} pizza", type);
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
		LOGGER.debug("Successful creation of {} pizza", type);
		return pizza;
	}
}
