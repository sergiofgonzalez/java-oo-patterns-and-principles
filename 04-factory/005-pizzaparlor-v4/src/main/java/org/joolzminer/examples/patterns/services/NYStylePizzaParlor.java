package org.joolzminer.examples.patterns.services;

import org.joolzminer.examples.patterns.domain.NYStyleCheesePizza;
import org.joolzminer.examples.patterns.domain.NYStylePepperoniPizza;
import org.joolzminer.examples.patterns.domain.NYStyleVeggiePizza;
import org.joolzminer.examples.patterns.domain.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NYStylePizzaParlor extends PizzaParlor {

	private static final Logger LOGGER = LoggerFactory.getLogger(NYStylePizzaParlor.class);
	
	@Override
	public Pizza createPizza(String type) {
		LOGGER.debug("Received message to instantiate a {} pizza", type);
		Pizza pizza;
		
		switch (type) {
			case "cheese":
				pizza = new NYStyleCheesePizza();
				break;
							
			case "pepperoni":
				pizza = new NYStylePepperoniPizza();
				break;
			
			case "veggie":
				pizza = new NYStyleVeggiePizza();
				break;
				
			default:
				throw new IllegalArgumentException("Unknown pizza type: " + type);
		}
		LOGGER.debug("Successful creation of {} pizza", type);
		return pizza;
	}

}
