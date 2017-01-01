package org.joolzminer.examples.patterns.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.joolzminer.examples.patterns.state.State;

public interface GumballMachineRemote extends Remote {
	
	int getCount() throws RemoteException;
	String getLocation() throws RemoteException;
	State getState() throws RemoteException;
}
