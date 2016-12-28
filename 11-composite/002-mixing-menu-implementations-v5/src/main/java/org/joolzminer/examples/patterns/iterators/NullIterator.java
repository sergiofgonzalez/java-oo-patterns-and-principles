package org.joolzminer.examples.patterns.iterators;

import java.util.Iterator;

import org.joolzminer.examples.patterns.composites.MenuComponent;

public class NullIterator implements Iterator<MenuComponent> {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public MenuComponent next() {
		return null;
	}

}
