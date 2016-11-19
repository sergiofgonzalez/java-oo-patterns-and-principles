package org.joolzminer.examples.patterns.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

import org.junit.Test;

public class DecoratorTest {
	
	@Test
	public void testHoublendDoubleMochaSoyLatteWithWhip() {
		/* Arrange */
		Beverage order = new Whip(new Soy(new Mocha(new Mocha(new HouseBlend()))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(equalTo(HouseBlend.COST
										.add(Soy.COST)
										.add(Mocha.COST)
										.add(Mocha.COST)
										.add(Whip.COST))));		
		assertThat(description, is(equalTo("House blend coffee with mocha with mocha with soy with whip")));
	}
	
	@Test
	public void testEspresso() {
		/* Arrange */
		Beverage order = new Espresso();
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(equalTo(Espresso.COST)));		
		assertThat(description, is(equalTo("Espresso")));
	}	
	
	@Test
	public void testDarkRoastWithDoubleMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Mocha(new DarkRoast())));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(equalTo(DarkRoast.COST
										.add(Mocha.COST)
										.add(Mocha.COST)
										.add(Whip.COST))));		

		assertThat(description, is(equalTo("Dark roast coffee with mocha with mocha with whip")));
	}		
	
	@Test
	public void testHouseBlendWithSoyMilkMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Soy(new HouseBlend())));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(equalTo(HouseBlend.COST
										.add(Soy.COST)
										.add(Mocha.COST)
										.add(Whip.COST))));		

		assertThat(description, is(equalTo("House blend coffee with soy with mocha with whip")));
	}		
}
