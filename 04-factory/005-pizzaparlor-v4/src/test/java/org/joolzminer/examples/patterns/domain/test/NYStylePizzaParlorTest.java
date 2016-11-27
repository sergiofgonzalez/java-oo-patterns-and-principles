package org.joolzminer.examples.patterns.domain.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import org.hamcrest.core.IsInstanceOf;
import org.joolzminer.examples.patterns.domain.NYStyleCheesePizza;
import org.joolzminer.examples.patterns.domain.NYStylePepperoniPizza;
import org.joolzminer.examples.patterns.domain.Pizza;
import org.joolzminer.examples.patterns.domain.VeggiePizza;
import org.joolzminer.examples.patterns.services.NYStylePizzaParlor;
import org.joolzminer.examples.patterns.services.PizzaParlor;
import org.junit.Test;

public class NYStylePizzaParlorTest {
	@Test
	public void testOrderNYStyleCheesePizza() {
		PizzaParlor pizzaParlorService = new NYStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("cheese");
		
		assertThat(pizza, IsInstanceOf.instanceOf(NYStyleCheesePizza.class));
		assertThat(pizza.getName(), is(equalTo("NYStyleCheesePizza")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrderNYStyleGreekPizzaFailsBecauseIsNotAvailable() {
		PizzaParlor pizzaParlorService = new NYStylePizzaParlor();
		
		pizzaParlorService.orderPizza("greek");		
	}
	
	@Test
	public void testOrderNYStylePepperoniPizza() {
		PizzaParlor pizzaParlorService = new NYStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("pepperoni");
		
		assertThat(pizza, IsInstanceOf.instanceOf(NYStylePepperoniPizza.class));
		assertThat(pizza.getName(), is(equalTo("NYStylePepperoniPizza")));
	}
	
	@Test
	public void testOrderNYStyleVeggiePizza() {
		PizzaParlor pizzaParlorService = new NYStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("veggie");
		
		assertThat(pizza, IsInstanceOf.instanceOf(VeggiePizza.class));
		assertThat(pizza.getName(), is(equalTo("NYStyleVeggiePizza")));
	}
}
