package org.joolzminer.examples.patterns.domain.pizzas;

import org.joolzminer.examples.patterns.domain.ingredients.PizzaIngredientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeggiePizza extends Pizza {

	private static final Logger LOGGER = LoggerFactory.getLogger(VeggiePizza.class);
	
	private PizzaIngredientFactory pizzaIngredientFactory;
	
	public VeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
		this.pizzaIngredientFactory = pizzaIngredientFactory;
	}
	
	@Override
	public void prepare() {
		LOGGER.debug("Pizza.prepare");
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		veggies = pizzaIngredientFactory.createVeggies();
	}

}
