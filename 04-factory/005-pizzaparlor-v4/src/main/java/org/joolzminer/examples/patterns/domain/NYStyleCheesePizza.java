package org.joolzminer.examples.patterns.domain;

public class NYStyleCheesePizza extends CheesePizza {
	
	public NYStyleCheesePizza() {
		this.name = "NYStyleCheesePizza";
		this.description = "NY Style Sauce and Cheese Pizza";
		this.dough = "Thin Crust Dough";
		this.sauce = "Marinara Sauce";
		
		this.toppings.add("Grated Reggiano Cheese");
	}
}
