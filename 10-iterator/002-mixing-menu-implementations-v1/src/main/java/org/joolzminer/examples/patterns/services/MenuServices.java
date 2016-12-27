package org.joolzminer.examples.patterns.services;

import java.text.NumberFormat;
import java.util.Optional;
import java.util.function.Predicate;

import org.joolzminer.examples.patterns.domain.BreakfastMenu;
import org.joolzminer.examples.patterns.domain.LunchMenu;
import org.joolzminer.examples.patterns.domain.MenuItem;
import org.joolzminer.examples.patterns.iterators.Iterator;

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
		printMenuThroughIterator(new LunchMenu().createIterator());		
	}
	
	public void printBreakfastMenu() {
		System.out.println("========== BREAKFAST MENU ==========");		
		printMenuThroughIterator(new BreakfastMenu().createIterator());

	}
	
	public void printVegetarianMenu() {
		System.out.println("========== VEG MENU =========");
		System.out.println("========== LUNCH MENU =======");		
		printMenuThroughIteratorWithPredicate(new LunchMenu().createIterator(), this::isItemVegetarian);


		System.out.println("========== BREAKFAST MENU =======");		
		printMenuThroughIteratorWithPredicate(new BreakfastMenu().createIterator(), this::isItemVegetarian);
	}
	
	public Boolean isItemVegetarian(String itemName) {
		Optional<Boolean> isVeg = findIfVegThroughIterator(itemName, new LunchMenu().createIterator());
		if (!isVeg.isPresent()) {
			isVeg = findIfVegThroughIterator(itemName, new BreakfastMenu().createIterator());
		}
		
		return isVeg.orElse(null);
	}
	
	private Optional<Boolean> findIfVegThroughIterator(String itemName, Iterator<MenuItem> iter) {
		Optional<Boolean> isVeg = Optional.empty();
		boolean found = false;
		while (!found && iter.hasNext()) {
			MenuItem menuItem = iter.next();
			if (menuItem.getName().equals(itemName)) {
				found = true;
				isVeg = Optional.of(menuItem.isVegetarian());					
			}			
		}	
		return isVeg;
	}
	
	private void printMenuThroughIterator(Iterator<MenuItem> iter) {
		while (iter.hasNext()) {
			printMenuItem(iter.next());
		}
	}
	
	private void printMenuThroughIteratorWithPredicate(Iterator<MenuItem> iter, Predicate<String> filterFn) {
		while (iter.hasNext()) {
			MenuItem menuItem = iter.next();
			if (filterFn.test(menuItem.getName())) {
				printMenuItem(menuItem);
			}
		}
	}
	
	private void printMenuItem(MenuItem menuItem) {
		System.out.println("+ " + menuItem.getName() + " " + currencyFormatter.format(menuItem.getPrice()));
		System.out.println("  " + menuItem.getDescription());
		System.out.println();
	}
	
}
