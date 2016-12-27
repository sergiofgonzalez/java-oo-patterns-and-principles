package org.joolzminer.examples.patterns.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CafeMenu {
	private Map<String,MenuItem> menuItems;
	
	public CafeMenu() {
		menuItems = new HashMap<>();
		
		addItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, new BigDecimal(3.99));
		addItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, new BigDecimal(3.69));
		addItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, new BigDecimal(4.29));
	}
	
	public void addItem(String name, String description, boolean vegetarian, BigDecimal price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(name, menuItem);
	}
	
	public Map<String,MenuItem> getItems() {
		return Collections.unmodifiableMap(menuItems);
	}
	
	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}
}
