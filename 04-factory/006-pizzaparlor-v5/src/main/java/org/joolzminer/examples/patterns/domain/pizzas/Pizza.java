package org.joolzminer.examples.patterns.domain.pizzas;

import java.util.Arrays;

import org.joolzminer.examples.patterns.domain.ingredients.Cheese;
import org.joolzminer.examples.patterns.domain.ingredients.Clams;
import org.joolzminer.examples.patterns.domain.ingredients.Dough;
import org.joolzminer.examples.patterns.domain.ingredients.Pepperoni;
import org.joolzminer.examples.patterns.domain.ingredients.Sauce;
import org.joolzminer.examples.patterns.domain.ingredients.Veggies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Pizza {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Pizza.class);


	protected Dough dough;
	protected Sauce sauce;
	protected Veggies[] veggies;
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clam;

		
	public abstract void prepare();
	
	public void bake() {
		LOGGER.debug("Pizza.bake");
		System.out.println("|- Baking the Pizza for 25 mins at 250 degrees Celsius");
	}
	
	public void cut() {
		LOGGER.debug("Pizza.cut");
		System.out.println("|- Cutting the Pizza in 8 portions");
	}
	
	public void box() {
		LOGGER.debug("Pizza.box");
		System.out.println("|- Placing the Pizza in the official Pizza parlor box");
	}

	public Dough getDough() {
		return dough;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public Veggies[] getVeggies() {
		return veggies;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public Pepperoni getPepperoni() {
		return pepperoni;
	}

	public Clams getClam() {
		return clam;
	}

	@Override
	public String toString() {
		return "Pizza [dough=" + dough + ", sauce=" + sauce + ", veggies="
				+ Arrays.toString(veggies) + ", cheese=" + cheese
				+ ", pepperoni=" + pepperoni + ", clam=" + clam + "]";
	}	
}
