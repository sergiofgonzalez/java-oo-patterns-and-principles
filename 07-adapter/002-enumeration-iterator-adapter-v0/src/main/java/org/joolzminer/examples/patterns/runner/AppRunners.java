package org.joolzminer.examples.patterns.runner;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.joolzminer.examples.patterns.adapter.EnumerationIteratorAdapter;

public class AppRunners {
	
	public static void main(String[] args) {
		// The Enumeration interface is a somewhat legacy interface used in Vectors, Hashtables, etc.
		Vector<String> v = new Vector<>();
		v.add("one");
		v.add("two");
		v.add("three");
		v.add("fourteen");

		printElements(v.elements());
		
		// The Iterator interface is the evolution of Enumeration, and it's used in the modern Collections
		List<String> l = new ArrayList<>();
		l.add("uno");
		l.add("dos");
		l.add("tres");
		l.add("catorce");
		printElements(l.iterator());
		
		// By using an adapter, we can use an Enumeration where an Iterator is expected
		EnumerationIteratorAdapter<String> enumerationIteratorAdapter = new EnumerationIteratorAdapter<>(v.elements());
		printElements(enumerationIteratorAdapter);		
	}
	
	private static void printSeparator() {
		System.out.println("=================================================================");
	}
	
	private static <T> void printElements(Enumeration<T> enumeration) {
		printSeparator();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		printSeparator();
	}
	
	private static <T> void printElements(Iterator<T> iterator) {
		printSeparator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		printSeparator();
	}
}
