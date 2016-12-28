package org.joolzminer.examples.patterns.iterators;

import java.util.Iterator;
import java.util.Stack;

import org.joolzminer.examples.patterns.composites.MenuComponent;

public class CompositeIterator implements Iterator<MenuComponent> {

	private Stack<Iterator<MenuComponent>> stack = new Stack<>();
	
	public CompositeIterator(Iterator<MenuComponent> iter) {
		stack.push(iter);
	}
	
	@Override
	public boolean hasNext() {
		if (stack.isEmpty()) {
			return false;
		} else {
			Iterator<MenuComponent> iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	@Override
	public MenuComponent next() {
		if (hasNext()) {
			Iterator<MenuComponent> iterator = stack.peek();
			MenuComponent menuComponent = iterator.next();
			stack.push(menuComponent.createIterator());
			return menuComponent;
		} else {
			return null;
		}
	}
}
