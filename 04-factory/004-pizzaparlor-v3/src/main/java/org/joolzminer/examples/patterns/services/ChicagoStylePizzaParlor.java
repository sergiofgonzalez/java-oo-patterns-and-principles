package org.joolzminer.examples.patterns.services;

import org.joolzminer.examples.patterns.domain.ChicagoStyleCheesePizza;
import org.joolzminer.examples.patterns.domain.ChicagoStylePepperoniPizza;
import org.joolzminer.examples.patterns.domain.ChicagoStyleVeggiePizza;
import org.joolzminer.examples.patterns.domain.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChicagoStylePizzaParlor extends PizzaParlor {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChicagoStylePizzaParlor.class);
	
	@Override
	public Pizza createPizza(String type) {
		LOGGER.debug("Received message to instantiate a {} pizza", type);
		Pizza pizza;
		
		switch (type) {
			case "cheese":
				pizza = new ChicagoStyleCheesePizza();
				break;
							
			case "pepperoni":
				pizza = new ChicagoStylePepperoniPizza();
				break;
			
			case "veggie":
				pizza = new ChicagoStyleVeggiePizza();
				break;
				
			default:
				throw new IllegalArgumentException("Unknown pizza type: " + type);
		}
		LOGGER.debug("Successful creation of {} pizza", type);
		return pizza;
	}


}
