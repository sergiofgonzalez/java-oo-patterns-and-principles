package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public class LunchMenu {
	private static final int MAX_ITEMS = 6;
	int numberOfItems;
	MenuItem[] menuItems;
	
	public LunchMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		numberOfItems = 0;
		
		addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, new BigDecimal(2.99));
		addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, new BigDecimal(2.99));
		addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, new BigDecimal(3.29));
		addItem("Hotdog", "A hot dog, with sauerkraut, relish, onions, topped with cheese", false, new BigDecimal(3.05));
	}
	
	public void addItem(String name, String description, boolean vegetarian, BigDecimal price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			throw new IllegalStateException("Lunch Menu max capacity has been reached");
		} else {
			menuItems[numberOfItems++] = menuItem;
		}
	}

	public MenuItem[] getMenuItems() {
		return Arrays.copyOf(menuItems, numberOfItems);
	}	
}
