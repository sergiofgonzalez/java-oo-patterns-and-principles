package org.joolzminer.examples.patterns.domain.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsInstanceOf;
import org.joolzminer.examples.patterns.domain.CheesePizza;
import org.joolzminer.examples.patterns.domain.PepperoniPizza;
import org.joolzminer.examples.patterns.domain.Pizza;
import org.joolzminer.examples.patterns.domain.VeggiePizza;
import org.joolzminer.examples.patterns.services.ChicagoStylePizzaParlor;
import org.joolzminer.examples.patterns.services.PizzaParlor;
import org.junit.Test;

public class ChicagoStylePizzaParlorTest {
	@Test
	public void testOrderChicagoStyleCheesePizza() {
		PizzaParlor pizzaParlorService = new ChicagoStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("cheese");
		
		assertThat(pizza, IsInstanceOf.instanceOf(CheesePizza.class));
		assertThat(pizza.getName(), is(equalTo("ChicagoStyleCheesePizza")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrderChicagoStyleGreekPizzaFailsBecauseIsNotAvailable() {
		PizzaParlor pizzaParlorService = new ChicagoStylePizzaParlor();
		
		pizzaParlorService.orderPizza("greek");		
	}
	
	@Test
	public void testOrderChicagoStylePepperoniPizza() {
		PizzaParlor pizzaParlorService = new ChicagoStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("pepperoni");
		
		assertThat(pizza, IsInstanceOf.instanceOf(PepperoniPizza.class));
		assertThat(pizza.getName(), is(equalTo("ChicagoStylePepperoniPizza")));
	}
	
	@Test
	public void testOrderChicagoStyleVeggiePizza() {
		PizzaParlor pizzaParlorService = new ChicagoStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("veggie");
		
		assertThat(pizza, IsInstanceOf.instanceOf(VeggiePizza.class));
		assertThat(pizza.getName(), is(equalTo("ChicagoStyleVeggiePizza")));
	}
}
