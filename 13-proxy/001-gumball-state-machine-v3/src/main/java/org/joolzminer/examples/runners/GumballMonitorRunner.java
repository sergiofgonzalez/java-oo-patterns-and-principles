package org.joolzminer.examples.runners;

import org.joolzminer.examples.patterns.GumballMonitor;
import org.joolzminer.examples.patterns.state.GumballMachine;

public class GumballMonitorRunner {
	
	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine("cinema", 10);
		GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
		
		gumballMonitor.report();
		
		gumballMachine.insertQuarter();
		gumballMonitor.report();
	}
}
