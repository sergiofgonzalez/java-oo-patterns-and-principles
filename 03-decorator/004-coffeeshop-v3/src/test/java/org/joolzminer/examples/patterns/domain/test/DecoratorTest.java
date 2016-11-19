package org.joolzminer.examples.patterns.domain.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

import org.joolzminer.examples.patterns.domain.Beverage;
import org.joolzminer.examples.patterns.domain.Beverage.Size;
import org.joolzminer.examples.patterns.domain.DarkRoast;
import org.joolzminer.examples.patterns.domain.Decaf;
import org.joolzminer.examples.patterns.domain.Espresso;
import org.joolzminer.examples.patterns.domain.HouseBlend;
import org.joolzminer.examples.patterns.domain.Milk;
import org.joolzminer.examples.patterns.domain.Mocha;
import org.joolzminer.examples.patterns.domain.Soy;
import org.joolzminer.examples.patterns.domain.Whip;
import org.junit.Test;

public class DecoratorTest {
	
	@Test
	public void testTallHoublendDoubleMochaSoyLatteWithWhip() {
		/* Arrange */
		Beverage order = new Whip(new Soy(new Mocha(new Mocha(new HouseBlend(Size.TALL)))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(HouseBlend.COST           
										.add(Soy.COST)        
										.add(Mocha.COST)      
										.add(Mocha.COST)      
										.add(Whip.COST), new BigDecimal("0.01"))));	
		assertThat(description, is(equalTo("TALL House blend coffee with mocha with mocha with soy with whip")));
	}
	
	@Test
	public void testGrandeHoublendDoubleMochaSoyLatteWithWhip() {
		/* Arrange */
		Beverage order = new Whip(new Soy(new Mocha(new Mocha(new HouseBlend(Size.GRANDE)))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(HouseBlend.COST.add(new BigDecimal("0.10"))
										.add(Soy.COST).add(new BigDecimal("0.05")
										.add(Mocha.COST).add(new BigDecimal("0.05"))
										.add(Mocha.COST).add(new BigDecimal("0.05"))
										.add(Whip.COST).add(new BigDecimal("0.05"))), new BigDecimal ("0.001"))));		
		assertThat(description, is(equalTo("GRANDE House blend coffee with mocha with mocha with soy with whip")));
	}
	
	@Test
	public void testVentiHoublendDoubleMochaSoyLatteWithWhip() {
		/* Arrange */
		Beverage order = new Whip(new Soy(new Mocha(new Mocha(new HouseBlend(Size.VENTI)))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(HouseBlend.COST.add(new BigDecimal("0.15"))
										.add(Soy.COST).add(new BigDecimal("0.10"))
										.add(Mocha.COST).add(new BigDecimal("0.10"))
										.add(Mocha.COST).add(new BigDecimal("0.10"))
										.add(Whip.COST).add(new BigDecimal("0.10")), new BigDecimal("0.001"))));		
		assertThat(description, is(equalTo("VENTI House blend coffee with mocha with mocha with soy with whip")));
	}
	
	@Test
	public void testTallEspresso() {
		/* Arrange */
		Beverage order = new Espresso(Size.TALL);
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(Espresso.COST, new BigDecimal("0.001"))));		
		assertThat(description, is(equalTo("TALL Espresso")));
	}	
	
	@Test
	public void testGrandeEspresso() {
		/* Arrange */
		Beverage order = new Espresso(Size.GRANDE);
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(Espresso.COST.add(new BigDecimal("0.10")), new BigDecimal("0.001"))));		
		assertThat(description, is(equalTo("GRANDE Espresso")));
	}	

	@Test
	public void testVentiTallEspresso() {
		/* Arrange */
		Beverage order = new Espresso(Size.VENTI);
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(Espresso.COST.add(new BigDecimal("0.15")), new BigDecimal("0.001"))));		
		assertThat(description, is(equalTo("VENTI Espresso")));
	}	
	
	@Test
	public void testTallDarkRoastWithDoubleMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Mocha(new DarkRoast(Size.TALL))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(DarkRoast.COST
										.add(Mocha.COST)
										.add(Mocha.COST)
										.add(Whip.COST), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("TALL Dark roast coffee with mocha with mocha with whip")));
	}		
	
	@Test
	public void testGrandeDarkRoastWithDoubleMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Mocha(new DarkRoast(Size.GRANDE))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(DarkRoast.COST.add(new BigDecimal("0.10"))
										.add(Mocha.COST).add(new BigDecimal("0.05"))
										.add(Mocha.COST).add(new BigDecimal("0.05"))
										.add(Whip.COST).add(new BigDecimal("0.05")), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("GRANDE Dark roast coffee with mocha with mocha with whip")));
	}		
	
	@Test
	public void testVentiDarkRoastWithDoubleMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Mocha(new DarkRoast(Size.VENTI))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(DarkRoast.COST.add(new BigDecimal("0.15"))
										.add(Mocha.COST).add(new BigDecimal("0.10"))
										.add(Mocha.COST).add(new BigDecimal("0.10"))
										.add(Whip.COST).add(new BigDecimal("0.10")), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("VENTI Dark roast coffee with mocha with mocha with whip")));
	}		
	
	@Test
	public void testTallHouseBlendWithSoyMilkMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Soy(new HouseBlend(Size.TALL))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(HouseBlend.COST
										.add(Soy.COST)
										.add(Mocha.COST)
										.add(Whip.COST), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("TALL House blend coffee with soy with mocha with whip")));
	}		
	
	@Test
	public void testGrandeHouseBlendWithSoyMilkMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Soy(new HouseBlend(Size.GRANDE))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(HouseBlend.COST.add(new BigDecimal("0.10"))
										.add(Soy.COST).add(new BigDecimal("0.05"))
										.add(Mocha.COST).add(new BigDecimal("0.05"))
										.add(Whip.COST).add(new BigDecimal("0.05")), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("GRANDE House blend coffee with soy with mocha with whip")));
	}
	
	@Test
	public void testVentiHouseBlendWithSoyMilkMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Soy(new HouseBlend(Size.VENTI))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(HouseBlend.COST.add(new BigDecimal("0.15"))
										.add(Soy.COST).add(new BigDecimal("0.10"))
										.add(Mocha.COST).add(new BigDecimal("0.10"))
										.add(Whip.COST).add(new BigDecimal("0.10")), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("VENTI House blend coffee with soy with mocha with whip")));
	}
	
	@Test
	public void testTallDecafWithMilkMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Milk(new Decaf(Size.TALL))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(Decaf.COST
										.add(Milk.COST)
										.add(Mocha.COST)
										.add(Whip.COST), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("TALL Decaf with steamed milk with mocha with whip")));
	}		
	
	@Test
	public void testGrandeDecafWithMilkMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Milk(new Decaf(Size.GRANDE))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(Decaf.COST.add(new BigDecimal("0.10"))
										.add(Milk.COST).add(new BigDecimal("0.05"))
										.add(Mocha.COST).add(new BigDecimal("0.05"))
										.add(Whip.COST).add(new BigDecimal("0.05")), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("GRANDE Decaf with steamed milk with mocha with whip")));
	}		

	@Test
	public void testVentiDecafWithMilkMochaAndWhip() {
		/* Arrange */
		Beverage order = new Whip(new Mocha(new Milk(new Decaf(Size.VENTI))));
		
		/* Act */
		BigDecimal cost = order.cost();
		String description = order.getDescription();
		
		/* Assert */
		assertThat(cost, is(closeTo(Decaf.COST.add(new BigDecimal("0.15"))
										.add(Milk.COST).add(new BigDecimal("0.10"))
										.add(Mocha.COST).add(new BigDecimal("0.10"))
										.add(Whip.COST).add(new BigDecimal("0.10")), new BigDecimal("0.001"))));		

		assertThat(description, is(equalTo("VENTI Decaf with steamed milk with mocha with whip")));
	}		
}
