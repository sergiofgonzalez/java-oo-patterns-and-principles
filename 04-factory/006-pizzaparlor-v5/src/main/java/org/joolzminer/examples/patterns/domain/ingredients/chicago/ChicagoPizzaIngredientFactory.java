package org.joolzminer.examples.patterns.domain.ingredients.chicago;

import org.joolzminer.examples.patterns.domain.ingredients.BlackOlives;
import org.joolzminer.examples.patterns.domain.ingredients.Cheese;
import org.joolzminer.examples.patterns.domain.ingredients.Clams;
import org.joolzminer.examples.patterns.domain.ingredients.Dough;
import org.joolzminer.examples.patterns.domain.ingredients.EggPlant;
import org.joolzminer.examples.patterns.domain.ingredients.Pepperoni;
import org.joolzminer.examples.patterns.domain.ingredients.PizzaIngredientFactory;
import org.joolzminer.examples.patterns.domain.ingredients.Sauce;
import org.joolzminer.examples.patterns.domain.ingredients.SlicedPepperoni;
import org.joolzminer.examples.patterns.domain.ingredients.Spinach;
import org.joolzminer.examples.patterns.domain.ingredients.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies[] veggies = {new BlackOlives(), new EggPlant(), new Spinach()};
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FrozenClams();
	}

}
