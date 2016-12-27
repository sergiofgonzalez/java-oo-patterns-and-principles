package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BreakfastMenu {
	private List<MenuItem> menuItems;
	
	public BreakfastMenu() {
		menuItems = new ArrayList<>();
		
		addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, new BigDecimal(2.99));
		addItem("Regular Pancake Breakfast", "Pancakes with fried egg, sausage", false, new BigDecimal(2.99));
		addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, new BigDecimal(3.49));
		addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, new BigDecimal(3.59));
	}
	
	public void addItem(String name, String description, boolean vegetarian, BigDecimal price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}

	public List<MenuItem> getMenuItems() {
		return Collections.unmodifiableList(menuItems);
	}
	
	public Iterator<MenuItem> createIterator() {
		return menuItems.iterator();
	}
}
