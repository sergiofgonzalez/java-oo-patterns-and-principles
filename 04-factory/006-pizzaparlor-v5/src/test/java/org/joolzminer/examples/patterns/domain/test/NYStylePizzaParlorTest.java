package org.joolzminer.examples.patterns.domain.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsInstanceOf;
import org.joolzminer.examples.patterns.domain.ingredients.SlicedPepperoni;
import org.joolzminer.examples.patterns.domain.ingredients.ny.FreshClams;
import org.joolzminer.examples.patterns.domain.ingredients.ny.MarinaraSauce;
import org.joolzminer.examples.patterns.domain.ingredients.ny.ReggianoCheese;
import org.joolzminer.examples.patterns.domain.ingredients.ny.ThinCrustDough;
import org.joolzminer.examples.patterns.domain.pizzas.CheesePizza;
import org.joolzminer.examples.patterns.domain.pizzas.ClamPizza;
import org.joolzminer.examples.patterns.domain.pizzas.PepperoniPizza;
import org.joolzminer.examples.patterns.domain.pizzas.Pizza;
import org.joolzminer.examples.patterns.services.ChicagoStylePizzaParlor;
import org.joolzminer.examples.patterns.services.NYStylePizzaParlor;
import org.joolzminer.examples.patterns.services.PizzaParlor;
import org.junit.Test;

public class NYStylePizzaParlorTest {

	@Test
	public void testOrderNYStyleCheesePizza() {
		PizzaParlor pizzaParlorService = new NYStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("cheese");
		
		assertThat(pizza, IsInstanceOf.instanceOf(CheesePizza.class));
		assertThat(pizza.getCheese(), is(instanceOf(ReggianoCheese.class)));
		assertThat(pizza.getSauce(), is(instanceOf(MarinaraSauce.class)));
		assertThat(pizza.getDough(), is(instanceOf(ThinCrustDough.class)));
		assertThat(pizza.getClam(), is(nullValue()));
		assertThat(pizza.getVeggies(), is(nullValue()));
		assertThat(pizza.getPepperoni(), is(nullValue()));
	}
	
	@Test
	public void testOrderNYStyleClamPizza() {
		PizzaParlor pizzaParlorService = new NYStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("clam");
		
		assertThat(pizza, IsInstanceOf.instanceOf(ClamPizza.class));
		assertThat(pizza.getCheese(), is(instanceOf(ReggianoCheese.class)));
		assertThat(pizza.getSauce(), is(instanceOf(MarinaraSauce.class)));
		assertThat(pizza.getDough(), is(instanceOf(ThinCrustDough.class)));
		assertThat(pizza.getClam(), is(instanceOf(FreshClams.class)));
		assertThat(pizza.getVeggies(), is(nullValue()));
		assertThat(pizza.getPepperoni(), is(nullValue()));
	}
	
	@Test
	public void testOrderNYStylePepperoniPizza() {
		PizzaParlor pizzaParlorService = new NYStylePizzaParlor();
		
		Pizza pizza = pizzaParlorService.orderPizza("pepperoni");
		
		assertThat(pizza, IsInstanceOf.instanceOf(PepperoniPizza.class));
		assertThat(pizza.getCheese(), is(instanceOf(ReggianoCheese.class)));
		assertThat(pizza.getSauce(), is(instanceOf(MarinaraSauce.class)));
		assertThat(pizza.getDough(), is(instanceOf(ThinCrustDough.class)));
		assertThat(pizza.getClam(), is(nullValue()));
		assertThat(pizza.getVeggies(), is(nullValue()));
		assertThat(pizza.getPepperoni(), is(instanceOf(SlicedPepperoni.class)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrderChicagoStyleGreekPizzaFailsBecauseIsNotAvailable() {
		PizzaParlor pizzaParlorService = new ChicagoStylePizzaParlor();
		
		pizzaParlorService.orderPizza("greek");		
	}
}
