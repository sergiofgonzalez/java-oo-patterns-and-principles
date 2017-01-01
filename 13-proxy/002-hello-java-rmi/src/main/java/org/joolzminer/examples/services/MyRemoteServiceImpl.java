package org.joolzminer.examples.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRemoteServiceImpl.class);
	
	public MyRemoteServiceImpl() throws RemoteException {
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Hey, Java RMI";
	}
}
