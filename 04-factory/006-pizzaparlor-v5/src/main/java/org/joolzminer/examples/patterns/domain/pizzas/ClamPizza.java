package org.joolzminer.examples.patterns.domain.pizzas;

import org.joolzminer.examples.patterns.domain.ingredients.PizzaIngredientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClamPizza extends Pizza {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClamPizza.class);
	
	private PizzaIngredientFactory pizzaIngredientFactory;
	
	public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
		this.pizzaIngredientFactory = pizzaIngredientFactory;
	}
	
	@Override
	public void prepare() {
		LOGGER.debug("Pizza.prepare");
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		clam = pizzaIngredientFactory.createClam();
	}

}
