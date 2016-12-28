package org.joolzminer.examples.patterns.composites;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class MenuItem extends MenuComponent {
	private final NumberFormat currencyFormatter;
	
	private String name;
	private String description;
	boolean vegetarian;
	BigDecimal price;

	public MenuItem(String name, String description, boolean vegetarian, BigDecimal price) {
		currencyFormatter = NumberFormat.getCurrencyInstance();
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public boolean isVegetarian() {
		return vegetarian;
	}

	@Override
	public void print() {
		System.out.println("+ " + name + " " + currencyFormatter.format(price));
		System.out.println("  " + description);
		System.out.println();
	}
}
