package org.joolzminer.examples.runners;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.joolzminer.examples.services.MyRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteServiceClientRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RemoteServiceClientRunner.class);
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		LOGGER.debug("Obtaining reference to remote service");
		MyRemoteService myRemoteService = (MyRemoteService) Naming.lookup("rmi://localhost/MyRemoteService");
		System.out.println(myRemoteService.sayHello());
	}
}
