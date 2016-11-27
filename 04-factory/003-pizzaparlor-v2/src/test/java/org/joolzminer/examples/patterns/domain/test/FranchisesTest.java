package org.joolzminer.examples.patterns.domain.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsInstanceOf;
import org.joolzminer.examples.patterns.domain.CheesePizza;
import org.joolzminer.examples.patterns.domain.PepperoniPizza;
import org.joolzminer.examples.patterns.domain.Pizza;
import org.joolzminer.examples.patterns.domain.VeggiePizza;
import org.joolzminer.examples.patterns.factories.NYPizzaFactory;
import org.joolzminer.examples.patterns.services.PizzaParlorService;
import org.junit.Test;

public class FranchisesTest {

	@Test
	public void testOrderNYStyleCheesePizza() {
		PizzaParlorService pizzaParlorService = new PizzaParlorService(new NYPizzaFactory());
		
		Pizza pizza = pizzaParlorService.orderPizza("cheese");
		
		assertThat(pizza, IsInstanceOf.instanceOf(CheesePizza.class));
		assertThat(pizza.getDescription(), is(equalTo("CheesePizza")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrderNYStyleGreekPizzaFailsBecauseIsNotAvailable() {
		PizzaParlorService pizzaParlorService = new PizzaParlorService(new NYPizzaFactory());
		
		pizzaParlorService.orderPizza("greek");		
	}
	
	@Test
	public void testOrderNYStylePepperoniPizza() {
		PizzaParlorService pizzaParlorService = new PizzaParlorService(new NYPizzaFactory());
		
		Pizza pizza = pizzaParlorService.orderPizza("pepperoni");
		
		assertThat(pizza, IsInstanceOf.instanceOf(PepperoniPizza.class));
		assertThat(pizza.getDescription(), is(equalTo("PepperoniPizza")));
	}
	
	@Test
	public void testOrderNYStyleVeggiePizza() {
		PizzaParlorService pizzaParlorService = new PizzaParlorService(new NYPizzaFactory());
		
		Pizza pizza = pizzaParlorService.orderPizza("veggie");
		
		assertThat(pizza, IsInstanceOf.instanceOf(VeggiePizza.class));
		assertThat(pizza.getDescription(), is(equalTo("VeggiePizza")));
	}
}
