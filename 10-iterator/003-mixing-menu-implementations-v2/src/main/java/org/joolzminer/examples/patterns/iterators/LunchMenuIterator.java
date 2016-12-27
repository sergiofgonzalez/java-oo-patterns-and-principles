package org.joolzminer.examples.patterns.iterators;

import java.util.Iterator;

import org.joolzminer.examples.patterns.domain.MenuItem;

public class LunchMenuIterator implements Iterator<MenuItem> {

	private MenuItem[] menuItems;
	private int pos;
	
	public LunchMenuIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
		pos = 0;
	}
	
	@Override
	public boolean hasNext() {
		return pos < menuItems.length;
	}

	@Override
	public MenuItem next() {
		return menuItems[pos++];
	}
}
