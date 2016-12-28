package org.joolzminer.examples.patterns.services;

import java.util.Iterator;

import org.joolzminer.examples.patterns.composites.Menu;
import org.joolzminer.examples.patterns.composites.MenuComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MenuServices {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuServices.class);
	
	private MenuComponent allMenus;
		
	public MenuServices(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
	
	public void printMenu() {
		allMenus.print();
	}

	public void printVegetarianMenu() {
		Iterator<MenuComponent> iter = allMenus.createIterator();
		System.out.println("===== VEG MENU =====");
		while (iter.hasNext()) {
			MenuComponent menuComponent = iter.next();
			try {
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {
				// Swallowing exception
			}
		}
	}	
	
	public void printBreakfastMenu() {
		printSubMenu("Breakfast Menu");
	}
	
	public void printLunchMenu() {
		printSubMenu("Lunch Menu");
	}
	
	public void printDinnerMenu() {
		printSubMenu("Dinner Menu");
	}
	
	private void printSubMenu(String subMenuName) {
		Iterator<MenuComponent> iter = allMenus.createIterator();
		boolean found = false;
		while (!found && iter.hasNext()) {
			MenuComponent menuComponent = iter.next();
			if (menuComponent.getName().equals(subMenuName)) {
				found = true;
				printSubMenu((Menu)menuComponent);
			}
		}
	}
	
	private void printSubMenu(Menu subMenu) {
		subMenu.print();
	}
}
