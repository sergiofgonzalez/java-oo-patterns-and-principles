package org.joolzminer.examples.patterns.services;

import org.joolzminer.examples.patterns.domain.ingredients.PizzaIngredientFactory;
import org.joolzminer.examples.patterns.domain.ingredients.ny.NYPizzaIngredientFactory;
import org.joolzminer.examples.patterns.domain.pizzas.CheesePizza;
import org.joolzminer.examples.patterns.domain.pizzas.ClamPizza;
import org.joolzminer.examples.patterns.domain.pizzas.PepperoniPizza;
import org.joolzminer.examples.patterns.domain.pizzas.Pizza;
import org.joolzminer.examples.patterns.domain.pizzas.VeggiePizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NYStylePizzaParlor extends PizzaParlor {

	private static final Logger LOGGER = LoggerFactory.getLogger(NYStylePizzaParlor.class);
	
	@Override
	public Pizza createPizza(String type) {
		LOGGER.debug("Received message to instantiate a {} pizza", type);
		Pizza pizza;
		PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
		
		switch (type) {
			case "cheese":
				pizza = new CheesePizza(pizzaIngredientFactory);
				break;
							
			case "pepperoni":
				pizza = new PepperoniPizza(pizzaIngredientFactory);
				break;
			
			case "veggie":
				pizza = new VeggiePizza(pizzaIngredientFactory);
				break;
				
			case "clam":
				pizza = new ClamPizza(pizzaIngredientFactory);
				break;
				
			default:
				throw new IllegalArgumentException("Unknown pizza type: " + type);
		}
		LOGGER.debug("Successful creation of {} pizza", type);
		return pizza;
	}

}
