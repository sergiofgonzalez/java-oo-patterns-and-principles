package org.joolzminer.examples.patterns;

public class Singleton {
	
	private Singleton() {		
	}

	private static class LazyHolder {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return LazyHolder.INSTANCE;
	}
}
