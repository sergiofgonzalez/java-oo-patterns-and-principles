package org.joolzminer.examples.patterns.iterators;

import java.util.List;

import org.joolzminer.examples.patterns.domain.MenuItem;

public class BreakfastMenuIterator implements Iterator<MenuItem> {

	private List<MenuItem> menuItems;
	private int pos;
	
	public BreakfastMenuIterator(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
		pos = 0;
	}
	
	@Override
	public boolean hasNext() {
		return pos < menuItems.size();
	}

	@Override
	public MenuItem next() {
		return menuItems.get(pos++);
	}

}
