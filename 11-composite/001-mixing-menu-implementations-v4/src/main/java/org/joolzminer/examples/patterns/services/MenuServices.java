package org.joolzminer.examples.patterns.services;

import org.joolzminer.examples.patterns.composites.MenuComponent;


public class MenuServices {

	private MenuComponent allMenus;
		
	public MenuServices(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
	
	public void printMenu() {
		allMenus.print();
	}

	public void printVegetarianMenu() {
		throw new UnsupportedOperationException();
	}	
	
	public void printSubMenu(String subMenuName) {
		throw new UnsupportedOperationException();
	}
}
