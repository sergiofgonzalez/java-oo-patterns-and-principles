package org.joolzminer.examples.patterns;

import org.joolzminer.examples.patterns.state.GumballMachine;

public class GumballMonitor {
	private GumballMachine gumballMachine;
	
	public GumballMonitor(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void report() {
		System.out.println("===================================================");
		System.out.println("Gumball Machine  : " + gumballMachine.getLocation());
		System.out.println("Current Inventory: " + gumballMachine.getCount() + " gumball(s)");
		System.out.println("Current State    : " + gumballMachine.getStateDescription());
	}
}
