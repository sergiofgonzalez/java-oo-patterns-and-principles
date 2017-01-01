package org.joolzminer.examples.patterns;

import java.rmi.RemoteException;

import org.joolzminer.examples.patterns.proxy.GumballMachineRemote;

public class GumballMonitor {
	private GumballMachineRemote gumballMachineRemote;
	
	public GumballMonitor(GumballMachineRemote gumballMachineRemote) {
		this.gumballMachineRemote = gumballMachineRemote;
	}
	
	public void report() throws RemoteException {
		System.out.println("===================================================");
		System.out.println("Gumball Machine  : " + gumballMachineRemote.getLocation());
		System.out.println("Current Inventory: " + gumballMachineRemote.getCount() + " gumball(s)");
		System.out.println("Current State    : " + gumballMachineRemote.getState());
	}
}
