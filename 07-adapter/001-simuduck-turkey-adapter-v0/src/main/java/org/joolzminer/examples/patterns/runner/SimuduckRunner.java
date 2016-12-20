package org.joolzminer.examples.patterns.runner;

import org.joolzminer.examples.patterns.adapter.Duck;
import org.joolzminer.examples.patterns.adapter.MallardDuck;
import org.joolzminer.examples.patterns.adapter.TurkeyAdapter;
import org.joolzminer.examples.patterns.adapter.WildTurkey;

public class SimuduckRunner {
	
	public static void main(String[] args) {
		// MallardDuck implements Duck => no need for adapter
		Duck d = new MallardDuck();
		d.fly();
		d.quack();
		printSeparator();
		
		// WildTurkey does not implement Duck => needs an adapter
		Duck t = new TurkeyAdapter(new WildTurkey());
		t.fly();
		t.quack();
		
	}
	
	private static void printSeparator() {
		System.out.println("=================================================================");
	}
}
