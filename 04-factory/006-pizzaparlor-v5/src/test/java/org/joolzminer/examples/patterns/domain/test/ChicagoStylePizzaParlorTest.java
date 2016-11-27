package org.joolzminer.examples.patterns.domain.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsInstanceOf;
import org.joolzminer.examples.patterns.domain.ingredients.chicago.MozzarellaCheese;
import org.joolzminer.examples.patterns.domain.ingredients.chicago.PlumTomatoSauce;
import org.joolzminer.examples.patterns.domain.ingredients.chicago.ThickCrustDough;
import org.joolzminer.examples.patterns.domain.pizzas.CheesePizza;
import org.joolzminer.examples.patterns.domain.pizzas.Pizza;
import org.joolzminer.examples.patterns.services.ChicagoStylePizzaParlor;
import org.joolzminer.examples.patterns.services.PizzaParlor;
import org.junit.Test;

public class ChicagoStylePizzaParlorTest {
	@Test
	public void testOrderChicagoStyleCheesePizza() {
		PizzaParlor pizzaParlorService = new ChicagoStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("cheese");
		
		assertThat(pizza, IsInstanceOf.instanceOf(CheesePizza.class));
		assertThat(pizza.getCheese(), is(instanceOf(MozzarellaCheese.class)));
		assertThat(pizza.getSauce(), is(instanceOf(PlumTomatoSauce.class)));
		assertThat(pizza.getDough(), is(instanceOf(ThickCrustDough.class)));
		assertThat(pizza.getClam(), is(nullValue()));
		assertThat(pizza.getVeggies(), is(nullValue()));
		assertThat(pizza.getPepperoni(), is(nullValue()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrderChicagoStyleGreekPizzaFailsBecauseIsNotAvailable() {
		PizzaParlor pizzaParlorService = new ChicagoStylePizzaParlor();
		
		pizzaParlorService.orderPizza("greek");		
	}
	

}
