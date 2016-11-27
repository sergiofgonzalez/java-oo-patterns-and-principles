package org.joolzminer.examples.patterns.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChicagoStyleCheesePizza extends CheesePizza {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChicagoStyleCheesePizza.class);
	
	public ChicagoStyleCheesePizza() {
		this.name = "ChicagoStyleCheesePizza";
		this.description = "Chicago Style Deep Dish Cheese Pizza";
		this.dough = "Extra Thick Crust Dough";
		this.sauce = "Plum Tomato Sauce";
		
		this.toppings.add("Shredded Mozzarella Cheese");
	}

	@Override
	public void cut() {
		LOGGER.debug("ChicagoStyleCheesePizza.cut");
		System.out.println("|- Cutting the Pizza " + name + " in 4 square portions");
	}
}
