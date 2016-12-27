package org.joolzminer.examples.patterns.services;

import java.text.NumberFormat;
import java.util.List;
import java.util.Optional;

import org.joolzminer.examples.patterns.domain.BreakfastMenu;
import org.joolzminer.examples.patterns.domain.LunchMenu;
import org.joolzminer.examples.patterns.domain.MenuItem;

public class MenuServices {

	private final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
	
	public MenuServices() {		
	}
	
	public void printMenu() {
		System.out.println("========== MENU ==========");
		printLunchMenu();
		printBreakfastMenu();
	}
	
	public void printLunchMenu() {
		System.out.println("========== LUNCH MENU ==========");
		MenuItem[] lunchMenuItems = new LunchMenu().getMenuItems();
		for (MenuItem menuItem : lunchMenuItems) {
			printMenuItem(menuItem);
		}		
	}
	
	public void printBreakfastMenu() {
		System.out.println("========== BREAKFAST MENU ==========");		
		List<MenuItem> breakfastMenuItems = new BreakfastMenu().getMenuItems();
		for (MenuItem menuItem : breakfastMenuItems) {
			printMenuItem(menuItem);
		}		
	}
	
	public void printVegetarianMenu() {
		System.out.println("========== VEG MENU =========");
		System.out.println("========== LUNCH MENU =======");		
		MenuItem[] lunchMenuItems = new LunchMenu().getMenuItems();
		for (MenuItem menuItem : lunchMenuItems) {
			if (menuItem.isVegetarian()) {
				printMenuItem(menuItem);
			}
		}		
		System.out.println("========== BREAKFAST MENU =======");		
		List<MenuItem> breakfastMenuItems = new BreakfastMenu().getMenuItems();
		for (MenuItem menuItem : breakfastMenuItems) {
			if (menuItem.isVegetarian()) {				
				printMenuItem(menuItem);
			}
		}		
	}
	
	public Optional<Boolean> isItemVegetarian(String itemName) {
		boolean found = false;
		Optional<Boolean> isVeg = Optional.empty();
		MenuItem[] lunchMenuItems = new LunchMenu().getMenuItems();
		for (MenuItem menuItem : lunchMenuItems) {
			if (menuItem.getName().equals(itemName)) {
				found = true;
				isVeg = Optional.of(menuItem.isVegetarian());					
			}
		}
		
		if (!found) {
			List<MenuItem> breakfastMenuItems = new BreakfastMenu().getMenuItems();
			for (MenuItem menuItem : breakfastMenuItems) {
				if (menuItem.getName().equals(itemName)) {
					found = true;
					isVeg = Optional.of(menuItem.isVegetarian());					
				}				
			}
		}
		return isVeg;
	}
	
	private void printMenuItem(MenuItem menuItem) {
		System.out.println("+ " + menuItem.getName() + " " + currencyFormatter.format(menuItem.getPrice()));
		System.out.println("  " + menuItem.getDescription());
		System.out.println();
	}
	
}
