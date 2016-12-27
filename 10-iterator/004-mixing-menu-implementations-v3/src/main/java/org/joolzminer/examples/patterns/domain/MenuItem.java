package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;

public class MenuItem {
	private String name;
	private String description;
	boolean vegetarian;
	BigDecimal price;

	public MenuItem(String name, String description, boolean vegetarian, BigDecimal price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", description=" + description + ", vegetarian=" + vegetarian + ", price=" + price + "]";
	}
}
