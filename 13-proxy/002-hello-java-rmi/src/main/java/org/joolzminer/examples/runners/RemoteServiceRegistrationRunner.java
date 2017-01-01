package org.joolzminer.examples.runners;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.joolzminer.examples.services.MyRemoteService;
import org.joolzminer.examples.services.MyRemoteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteServiceRegistrationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(RemoteServiceRegistrationRunner.class);
	
	public static void main(String[] args) {
		LOGGER.debug("About to register remote service in the RMI registry");
		try {
			LocateRegistry.createRegistry(1099);
			MyRemoteService myRemoteService = new MyRemoteServiceImpl();
			Naming.rebind("MyRemoteService", myRemoteService);
		} catch (Exception e) {
			LOGGER.error("Could not rebind remote service", e);
			throw new IllegalStateException(e);
		}
		
		LOGGER.debug("Successfully registered service in the RMI Registry!!!");
		LOGGER.debug("Listening for remote calls...");
	}
}
