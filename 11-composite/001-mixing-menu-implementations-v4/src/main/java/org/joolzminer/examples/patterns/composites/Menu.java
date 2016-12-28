package org.joolzminer.examples.patterns.composites;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {

	private List<MenuComponent> menuComponents;
	
	private String name;
	private String description;
	
	public Menu(String name, String description) {
		menuComponents = new ArrayList<>();
		this.name = name;
		this.description = description;
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
	public void print() {
		System.out.println("============== " + name + " (" + description + ") ==============");
		Iterator<MenuComponent> iter = menuComponents.iterator();
		while (iter.hasNext()) {
			iter.next().print();
		}
	}
	
	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}

	@Override
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);	}

	@Override
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}
}
