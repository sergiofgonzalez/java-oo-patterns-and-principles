package org.joolzminer.examples.patterns.domain.runner;

import java.math.BigDecimal;

import org.joolzminer.examples.patterns.composites.Menu;
import org.joolzminer.examples.patterns.composites.MenuComponent;
import org.joolzminer.examples.patterns.composites.MenuItem;
import org.joolzminer.examples.patterns.services.MenuServices;


public class MenuRunner {

	public static void main(String[] args) {		
		MenuServices menuServices = new MenuServices(getAllMenus());
		
		menuServices.printMenu();
		printSeparator();
		
		menuServices.printVegetarianMenu();
		printSeparator();
		
		menuServices.printBreakfastMenu();
		printSeparator();
		
		menuServices.printLunchMenu();
		printSeparator();
		
		menuServices.printDinnerMenu();
		printSeparator();
	}
	
	
	private static MenuComponent getAllMenus() {
		MenuComponent breakfastMenu = new Menu("Breakfast Menu", "Breakfast");
		MenuComponent lunchMenu = new Menu("Lunch Menu", "Lunch");
		MenuComponent dinnerMenu = new Menu("Dinner Menu", "Dinner");
		MenuComponent dessertMenu = new Menu("Dessert Menu", "Desserts for lunch");
		
		MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
		allMenus.add(breakfastMenu);
		allMenus.add(lunchMenu);
		allMenus.add(dinnerMenu);
		
		breakfastMenu.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, new BigDecimal(2.99)));
		breakfastMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried egg, sausage", false, new BigDecimal(2.99)));
		breakfastMenu.add(new MenuItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, new BigDecimal(3.49)));
		breakfastMenu.add(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, new BigDecimal(3.59)));
		
		lunchMenu.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, new BigDecimal(2.99)));
		lunchMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, new BigDecimal(2.99)));
		lunchMenu.add(new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false, new BigDecimal(3.29)));
		lunchMenu.add(new MenuItem("Hotdog", "A hot dog, with sauerkraut, relish, onions, topped with cheese", false, new BigDecimal(3.05)));
		
		lunchMenu.add(dessertMenu);
		dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla ice cream", true, new BigDecimal(1.59)));
		
		dinnerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, new BigDecimal(3.89)));
		
		return allMenus;
	}
	
	private static void printSeparator() {
		System.out.println();
	}
}
