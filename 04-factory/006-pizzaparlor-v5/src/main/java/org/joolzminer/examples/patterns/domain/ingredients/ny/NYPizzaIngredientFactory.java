package org.joolzminer.examples.patterns.domain.ingredients.ny;

import org.joolzminer.examples.patterns.domain.ingredients.Cheese;
import org.joolzminer.examples.patterns.domain.ingredients.Clams;
import org.joolzminer.examples.patterns.domain.ingredients.Dough;
import org.joolzminer.examples.patterns.domain.ingredients.Garlic;
import org.joolzminer.examples.patterns.domain.ingredients.Mushroom;
import org.joolzminer.examples.patterns.domain.ingredients.Onion;
import org.joolzminer.examples.patterns.domain.ingredients.Pepperoni;
import org.joolzminer.examples.patterns.domain.ingredients.PizzaIngredientFactory;
import org.joolzminer.examples.patterns.domain.ingredients.RedPepper;
import org.joolzminer.examples.patterns.domain.ingredients.Sauce;
import org.joolzminer.examples.patterns.domain.ingredients.SlicedPepperoni;
import org.joolzminer.examples.patterns.domain.ingredients.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies[] veggies = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}

}
