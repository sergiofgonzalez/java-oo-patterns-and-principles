# 002-hello-java-rmi
> crash course on Java RMI before exploring Remote Proxies

## Application Description

A self-contained example that illustrates the basic building blocks of Java RMI, that allows an external client to instantiate and invoke classes running in a separate JVM.

### Server JVM
In the example, a *Remote* service is declared using `MyRemoteService`. The service is then implemented by `MyRemoteServiceImpl`.

The `RemoteServiceRegistrationRunner` is in charge of starting the RMI registry (so that the example can be self-contained, with no additional programs needed) and then exposing the service to the world using the `rebind` method.

### Client JVM
The `RemoteServiceClientRunner` is an app in charge of contacting the RMI Registry and getting a reference to the remote service. Once obtained, the service can then be called as if it were local.

## Running the application
The example is prepared to be run from Eclipse:
1. Run the `RemoteServiceRegistrationRunner` app, which starts the registry and registers `MyRemoteService` so that it can be invoked via RMI.

2. Run the `RemoteServiceClientrunner` app, which uses Java RMI to invoke `MyRemoteService` methods. Note that the `RemoteServiceRegistrationRunner` must be running.

If you want to run the example outside of Eclipse, you might need to make sure that the registry has access to all the dependencies the remote service needs.
