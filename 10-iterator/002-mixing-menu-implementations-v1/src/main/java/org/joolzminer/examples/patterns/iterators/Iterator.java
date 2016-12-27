package org.joolzminer.examples.patterns.iterators;

public interface Iterator<T> {
	boolean hasNext();
	T next();
}
