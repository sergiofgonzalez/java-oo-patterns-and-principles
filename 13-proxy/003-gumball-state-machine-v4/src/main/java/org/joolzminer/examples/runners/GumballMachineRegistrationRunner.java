package org.joolzminer.examples.runners;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import org.joolzminer.examples.patterns.state.GumballMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GumballMachineRegistrationRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GumballMachineRegistrationRunner.class);
	
	public static void main(String[] args) {
		LOGGER.debug("About to register Gumball machine(s)");
		try {
			LocateRegistry.createRegistry(1099);
			GumballMachine gumballMachine = new GumballMachine("Odeon Theater - Main St.", 5);
			Naming.rebind("GumballMachine0", gumballMachine);

			gumballMachine = new GumballMachine("Kine Theater - Important St.", 10);
			Naming.rebind("GumballMachine1", gumballMachine);			
			
			gumballMachine = new GumballMachine("Multiplex Theater - Great St.", 15);
			Naming.rebind("GumballMachine2", gumballMachine);			
			
		} catch (Exception e) {
			LOGGER.debug("Error registering Gumball machine in RMI Registry:", e);
		}
		
		LOGGER.debug("Successfully registered Gumball machine(s) remote services");
		LOGGER.debug("Waiting for requests...");
	}
}
