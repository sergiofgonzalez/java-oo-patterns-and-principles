package org.joolzminer.examples.patterns;

public class Singleton {
	private static Singleton singleton = new Singleton();
	
	private Singleton() {		
	}
	
	public static synchronized Singleton getInstance() {
		return singleton;
	}
}
