package org.joolzminer.examples.patterns.domain.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsInstanceOf;
import org.joolzminer.examples.patterns.domain.CheesePizza;
import org.joolzminer.examples.patterns.domain.GreekPizza;
import org.joolzminer.examples.patterns.domain.PepperoniPizza;
import org.joolzminer.examples.patterns.domain.Pizza;
import org.joolzminer.examples.patterns.services.PizzaParlorService;
import org.junit.Test;

public class DomainTest {

	@Test
	public void testOrderCheesePizza() {
		PizzaParlorService pizzaParlorService = new PizzaParlorService();
		
		Pizza pizza = pizzaParlorService.orderPizza("cheese");
		
		assertThat(pizza, IsInstanceOf.instanceOf(CheesePizza.class));
		assertThat(pizza.getDescription(), is(equalTo("CheesePizza")));
	}
	
	@Test
	public void testOrderGreekPizza() {
		PizzaParlorService pizzaParlorService = new PizzaParlorService();
		
		Pizza pizza = pizzaParlorService.orderPizza("greek");
		
		assertThat(pizza, IsInstanceOf.instanceOf(GreekPizza.class));
		assertThat(pizza.getDescription(), is(equalTo("GreekPizza")));
	}
	
	@Test
	public void testOrderPepperoniPizza() {
		PizzaParlorService pizzaParlorService = new PizzaParlorService();
		
		Pizza pizza = pizzaParlorService.orderPizza("pepperoni");
		
		assertThat(pizza, IsInstanceOf.instanceOf(PepperoniPizza.class));
		assertThat(pizza.getDescription(), is(equalTo("PepperoniPizza")));
	}
}
