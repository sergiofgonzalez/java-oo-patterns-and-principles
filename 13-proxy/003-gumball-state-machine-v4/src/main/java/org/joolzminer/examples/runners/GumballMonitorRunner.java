package org.joolzminer.examples.runners;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.joolzminer.examples.patterns.GumballMonitor;
import org.joolzminer.examples.patterns.proxy.GumballMachineRemote;

public class GumballMonitorRunner {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
		
		GumballMachineRemote gumballMachineRemote = (GumballMachineRemote) Naming.lookup("GumballMachine0");		
		GumballMonitor gumballMonitor = new GumballMonitor(gumballMachineRemote);		
		gumballMonitor.report();
		
		gumballMachineRemote = (GumballMachineRemote) Naming.lookup("GumballMachine1");		
		gumballMonitor = new GumballMonitor(gumballMachineRemote);		
		gumballMonitor.report();
		
		gumballMachineRemote = (GumballMachineRemote) Naming.lookup("GumballMachine2");		
		gumballMonitor = new GumballMonitor(gumballMachineRemote);		
		gumballMonitor.report();
	}
}
