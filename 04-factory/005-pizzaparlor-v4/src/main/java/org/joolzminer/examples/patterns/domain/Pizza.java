package org.joolzminer.examples.patterns.domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Pizza {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Pizza.class);
	protected String name;
	protected String description;
	protected String dough;
	protected String sauce;
	protected List<String> toppings = new ArrayList<>();
		
	public void prepare() {
		LOGGER.debug("Pizza.prepare");
		System.out.println("|- Preparing " + name + " which is a " + description);
		System.out.println("|- Tossing " + dough + " dough");
		System.out.println("|- Pouring " + sauce + " sauce");
		System.out.println("|- Adding " + toppings.size() + " topping(s):");
		toppings.forEach(topping -> System.out.println("  |-- " + topping));
	}
	
	public void bake() {
		LOGGER.debug("Pizza.bake");
		System.out.println("|- Baking the Pizza " + name + " for 25 mins at 250 degrees Celsius");
	}
	
	public void cut() {
		LOGGER.debug("Pizza.cut");
		System.out.println("|- Cutting the Pizza " + name + " in 8 portions");
	}
	
	public void box() {
		LOGGER.debug("Pizza.box");
		System.out.println("|- Placing the Pizza " + name + " in the official Pizza parlor box");
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public String getDough() {
		return dough;
	}

	public String getSauce() {
		return sauce;
	}

	public List<String> getToppings() {
		return toppings;
	}	
}
